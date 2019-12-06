
import java.math.BigInteger;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dande
 */
public class MRTest {
    public static boolean MR(BigInteger number){
        if(number.compareTo(BigInteger.TWO) == -1) //kisebb-e mint 2
            return false;
        
        if(number.compareTo(BigInteger.TWO) == 0 ||
            number.compareTo(BigInteger.valueOf(3)) == 0){ //2? 3?
            return true;
        }
        
        if(number.mod(BigInteger.TWO) == BigInteger.ZERO) //páros-e a number
            return false;
        
        BigInteger d = number.subtract(BigInteger.ONE);
        
        int s = 0;
     
        while((d.mod(BigInteger.TWO)).equals(BigInteger.ZERO)){
            d = d.divide(BigInteger.TWO);
            s++;
        }
        
        //Próbák száma 2
        for(int i=0; i<2; i++){
            Random rnd = new Random();
            BigInteger a = new BigInteger(8, rnd);

            do {
                a = new BigInteger(8, rnd);
            }while(a.compareTo(number.subtract(BigInteger.ONE)) >= 0 ||
                    a.compareTo(BigInteger.ONE) <= 0);
           if(tryCompisite(a, d, s, number)){
               return false;
           }
        }       

        return true;
    }
    
    public static boolean tryCompisite(BigInteger a, BigInteger d, int s, BigInteger number){
        
        BigInteger eredmeny = FastModPow.quickPow(a, d, number);
            if(eredmeny.equals(BigInteger.ONE))
                return false;
            
            
            for(int j=0; j<s; j++){
                eredmeny = FastModPow.quickPow(a, (BigInteger.TWO.pow(j)).multiply(d), number);
                if(eredmeny.equals(number.subtract(BigInteger.ONE)))
                    return false;
                        
            }
        return true;
    }
    
}
