package com.skillmatch.tests;

/**
 * Created by agermenos on 6/8/16.
 */
public class PrimeNumbers {
    public static void main (String args[]){
        for (int k=0; k<5; k++){
            Integer testValue = (int)(50 * Math.random());
            System.out.println("Is " + testValue + " prime? " + isPrime(testValue));
        }
    }

    private static boolean isPrime(Integer testValue) {
        for (int k=testValue-1; k>1; k--) {
            if (testValue%k==0) {
                return false;
            }
        }
        return true;
    }
}
