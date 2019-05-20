package com.securitywhitepapers.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Set;

public class SecureRandomAlgorithms {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        final Set<String> algorithms = Security.getAlgorithms("SecureRandom");

        for (String algorithm : algorithms) {
          System.out.println(algorithm);
        }

        final String defaultAlgorithm = new SecureRandom().getAlgorithm();
        System.out.println("default: " + defaultAlgorithm);
        
        
        
    }

}
