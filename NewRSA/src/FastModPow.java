
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dande
 */
public class FastModPow {
    
    //a^b modulo mod
    //
    
    public static BigInteger quickPow(BigInteger a, BigInteger b, BigInteger modulo) {
        //Gyorshatványozás
        BigInteger result = BigInteger.ONE;
        while (b.compareTo(BigInteger.ZERO) > 0) {
            if (b.testBit(0))
                result = (result.multiply(a)).mod(modulo);
            b = b.shiftRight(1);
            a = (a.multiply(a)).mod(modulo);
            
        }
        return result.mod(modulo);
    }
}
