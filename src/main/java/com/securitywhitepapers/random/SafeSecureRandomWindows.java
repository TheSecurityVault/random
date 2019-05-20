package com.securitywhitepapers.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SafeSecureRandomWindows {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        try 
        {
            SecureRandom sr = SecureRandom.getInstance("WINDOWS-PRNG");
            sr.nextInt();
        } 
        catch (NoSuchAlgorithmException ex) 
        {
            Logger.getLogger(SafeSecureRandomWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
