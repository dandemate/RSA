
import java.math.BigInteger;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dande
 */
public class EEA {
    private BigInteger lnko;
    private BigInteger x;
    private BigInteger y;
    private BigInteger p;
    private BigInteger q;
    private BigInteger yp;
    private BigInteger yq;
    private boolean n; //true = páros vagy nulla, false = páratlan
    private BigInteger negX;

    public BigInteger getNegX() {
        return negX;
    }

    public void setNegX(BigInteger negX) {
        this.negX = negX;
    }

    public BigInteger getYp() {
        return yp;
    }

    public void setYp(BigInteger yp) {
        this.yp = yp;
    }

    public BigInteger getYq() {
        return yq;
    }

    public void setYq(BigInteger yq) {
        this.yq = yq;
    }
    
    public boolean isN() {
        return n;
    }

    public void setN(boolean n) {
        this.n = n;
    }
    
    public BigInteger getLnko() {
        return lnko;
    }

    public void setLnko(BigInteger lnko) {
        this.lnko = lnko;
    }

    public BigInteger getX() {
        return x;
    }

    public void setX(BigInteger x) {
        this.x = x;
    }

    public BigInteger getY() {
        return y;
    }

    public void setY(BigInteger y) {
        this.y = y;
    }

    public static EEA algorithm(BigInteger p, BigInteger q){
        //definíció szerint
        BigInteger x = BigInteger.ZERO; 
        BigInteger lastx = BigInteger.ONE; //x_(k-1)
        BigInteger y = BigInteger.ONE;
        BigInteger lasty = BigInteger.ZERO; //y_(k-1)
        
        BigInteger temp;
        BigInteger[] quotientAndRemainder;
        BigInteger quotient;
        boolean N = false;
        int db = 0;
        
        while (!q.equals(BigInteger.ZERO))
        {
            N = !N; //váltakozik minden ciklusmeg lefutáskor
            //quotientAndRemainder[0] -> hányados
            //quotientAndRemainder[1] -> maradék
            quotientAndRemainder = p.divideAndRemainder(q);
            quotient = quotientAndRemainder[0];

            temp = p;
            p = q;
            q = quotientAndRemainder[1];

            temp = x;
            x = lastx.subtract(quotient.multiply(x));
            lastx = temp;

            temp = y;
            y = lasty.subtract(quotient.multiply(y));
            lasty = temp;
            db++;
        }
        
        EEA result = new EEA();
        result.setX(lastx);
        result.setY(lasty);
        result.setLnko(p);
        result.setN(N);
        
        //x és y utolsó eleme *(-1)^n
        BigInteger yp = (BigInteger.ONE.negate()).pow(db).multiply(lastx);
        BigInteger yq = (BigInteger.ONE.negate()).pow(db+1).multiply(lasty);
        
        result.setYp(yp);
        result.setYq(yq);
        
        return result;
    }
    
}
