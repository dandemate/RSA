
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
public class CRT {
    public static BigInteger crt(BigInteger P,BigInteger Q , BigInteger D , BigInteger c) {
        
        BigInteger mP = FastModPow.quickPow(c,D.mod(P.subtract(BigInteger.ONE)),P);
        BigInteger mQ = FastModPow.quickPow(c,D.mod(Q.subtract(BigInteger.ONE)),Q);
        BigInteger N = P.multiply(Q);
        EEA eea = EEA.algorithm(P, Q);
        BigInteger x = eea.getX();
        BigInteger y = eea.getY();
        BigInteger yp = eea.getYp();
        BigInteger yq = eea.getYq();
        
        
        BigInteger m = ((mP.multiply(yq).multiply(Q)).add(mQ.multiply(yp).multiply(P))).mod(N);

        return m;
    }
}
