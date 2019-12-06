
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
public class Euclid {
    public static BigInteger euclid(BigInteger p, BigInteger q){
        BigInteger tmp;
        while(!(q.equals(BigInteger.ZERO))){
            tmp = q;
            q = p.mod(q);
            p = tmp;
        }
        return p;
    }
}
