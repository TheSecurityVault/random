package com.securitywhitepapers.random;

import java.util.Random;

public class SameSeed {

    public static void main(String[] args) {
        
        Random r1 = new Random(1);
        Random r2 = new Random(1);
        
        for(int i = 0; i < 10; i++)
        {
            int v2 = r2.nextInt();
            int v1 = r1.nextInt();
            
            System.out.println(String.format("Same value: %b", v1 == v2));
        }
        
        
    }

}
