package com.securitywhitepapers.random;

import java.lang.reflect.Field;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecureRandomUnderneathObject {

    public static void main(String[] args) {
            
        try 
        {
            //sun.security.mscapi.PRNG
            //http://hg.openjdk.java.net/jdk9/dev/jdk/file/65464a307408/src/jdk.crypto.mscapi/windows/classes/sun/security/mscapi/PRNG.java
            SecureRandom sr = SecureRandom.getInstance("WINDOWS-PRNG");
            System.out.println(getUnderneathClass(sr).getClass().getName());
            
            //sun.security.provider.SecureRandom
            //https://hg.openjdk.java.net/jdk7/jdk7/jdk/file/tip/src/share/classes/sun/security/provider/SecureRandom.java
            //https://github.com/netroby/jdk9-dev/blob/master/jdk/src/java.base/share/classes/sun/security/provider/SecureRandom.java
            SecureRandom sr1 = SecureRandom.getInstance("SHA1PRNG");
            System.out.println(getUnderneathClass(sr1).getClass().getName());
            
            //sun.security.provider.DRBG
            //https://github.com/netroby/jdk9-dev/blob/master/jdk/src/java.base/share/classes/sun/security/provider/DRBG.java
            SecureRandom sr2 = SecureRandom.getInstance("DRBG");
            System.out.println(getUnderneathClass(sr2).getClass().getName());
        } 
        catch (NoSuchAlgorithmException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(SecureRandomUnderneathObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Object getUnderneathClass(SecureRandom sr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
    {
        Field f = sr.getClass().getDeclaredField("secureRandomSpi"); 
        f.setAccessible(true);
        return f.get(sr); 
    }

}
