
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
public class Main {
    public static final String Message = "aasdasdasda";
    
    public static String BigIntToString(BigInteger m){
        byte[] bytes = m.toByteArray();
        String decryptedMessage = new String(bytes);
        return decryptedMessage;
    }
    
    public static void main(String[] args) {

        RSAClass r = new RSAClass();

        BigInteger m = new BigInteger(Message.getBytes());
        BigInteger c = FastModPow.quickPow(m, r.getE(), r.getN());
        System.out.println("Üzenet: "+Message);
        System.out.println(m);
        System.out.println(c);

        BigInteger result = CRT.crt(r.getP(), r.getQ(), r.getD(), c);
        String visszafejtve = BigIntToString(result);
        System.out.println(result);
        System.out.println("Visszefejtett üzenet: "+visszafejtve);
        
        
//        EEA eea = EEA.algorithm(BigInteger.valueOf(5), BigInteger.valueOf(17));
        //BigInteger t[] = EEA.extEuclid(BigInteger.valueOf(5), BigInteger.valueOf(17));
        
//        System.out.println("EEA obj--------------------------------------");
//        System.out.println(eea.getLnko());
//        System.out.println(eea.getX());
//        System.out.println(eea.getY());
//        System.out.println(eea.getYp());
//        System.out.println(eea.getYq());
//        System.out.println(eea.getNegX());
//        System.out.println("EEA tömb-------------------------------------");
//        System.out.println(t[0]);
//        System.out.println(t[1]);
//        System.out.println(t[2]);
        
    }
    
    
    
}
