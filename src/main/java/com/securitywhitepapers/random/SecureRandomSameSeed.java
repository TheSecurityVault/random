package com.securitywhitepapers.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureRandomSameSeed {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        //defining a seed like this is insecure for all scenarios
        
        //same outputs
        SecureRandom sr1 = SecureRandom.getInstance("SHA1PRNG");
        sr1.setSeed(123);
        SecureRandom sr2 = SecureRandom.getInstance("SHA1PRNG");
        sr2.setSeed(123);
        System.out.println(sr1.nextInt() + " | " + sr2.nextInt());
        
        
        //different outputs
        SecureRandom sr3 = SecureRandom.getInstance("WINDOWS-PRNG");
        sr3.setSeed(123);
        SecureRandom sr4 = SecureRandom.getInstance("WINDOWS-PRNG");
        sr4.setSeed(123);
        System.out.println(sr3.nextInt() + " | " + sr4.nextInt());
        
         //different outputs
        SecureRandom sr5 = SecureRandom.getInstance("DRBG");
        sr5.setSeed(123);
        SecureRandom sr6 = SecureRandom.getInstance("DRBG");
        sr6.setSeed(123);
        System.out.println(sr5.nextInt() + " | " + sr6.nextInt());
        
    }

}
