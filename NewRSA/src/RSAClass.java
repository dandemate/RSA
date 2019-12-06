
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


public class RSAClass {
    public static int size = 256;
    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phiN;
    private BigInteger e; //nyilvános kitevője
    private BigInteger d; //titkos kulcs kitevője
    
    public RSAClass(){
        this.p = randomPrime();
        
        this.q = randomPrime();
        
        this.N = p.multiply(q);
        
        this.phiN = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        
        this.e = randomNumber();
        while(!Euclid.euclid(e, phiN).equals(BigInteger.ONE)){
            this.e = randomNumber();
        }
        System.out.println("e kiszámolva");
        //d kiszámolása
        EEA eea = EEA.algorithm(this.e, this.phiN);
        this.d = eea.getYq();
                    
        //this.d = this.d.clearBit(0);
//        BigInteger[] dxy = EEA.extEuclid(this.e, this.phiN);
//        System.out.println("Tömb: "+dxy[1]);
//        if(dxy[1].compareTo(BigInteger.ONE)<0) {
//        	d = dxy[1].add(this.phiN);
//                System.out.println("Tömb: "+d);
//        }else if(dxy[1].compareTo(this.phiN)>0){
//                
//        	d = dxy[1].subtract(this.phiN);
//                System.out.println("Tömb: "+d);
//        }else {
//            
//        	d = dxy[1];
//                System.out.println("Tömb: "+d);
//        }
        
        
        System.out.println("d kiszámolva");
//        BigInteger eeaX = eeaResult.getYp(); 
//
//        if(eeaX.compareTo(BigInteger.ONE) == -1) //ha eeaX negatív
//            this.d = eeaX.add(this.phiN);
//        else if(eeaX.compareTo(this.phiN) == 1) //ha eeaX 
//            this.d = eeaX.subtract(this.phiN);
//        else
//            this.d = eeaX;
    }
    
    public BigInteger randomPrime(){ 
        BigInteger prime;
        do{
            prime = new BigInteger(size, new Random());
            prime = prime.setBit(0).setBit(size);
        }while(!MRTest.MR(prime));
        
        return prime;
    }
    
    public BigInteger randomNumber(){
        BigInteger random;
        random = new BigInteger(size, new Random());
        random = random.setBit(0).setBit(size);

        return random;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getN() {
        return N;
    }

    public BigInteger getPhiN() {
        return phiN;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }
    
}
