package com.securitywhitepapers.random;


import java.util.Random;

public class Replicate {

    public static void main(String[] args) {
        
        Random r = new Random();
        ReplicatedRandom rr = new ReplicatedRandom();
        
        //assuming we got to know 2 sequential "random" values generated
        rr.replicateState(r.nextInt(), r.nextInt()); 
        
        for(int i = 0; i < 10; i++)
        {
            int randomValue = r.nextInt();
            int replicatedValue = rr.nextInt();
            
            System.out.println(String.format("Same value: %b", randomValue == replicatedValue));
        }
        
        
    }

}
