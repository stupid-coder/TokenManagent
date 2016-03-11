package com.buaa;

/**
 * Created by stupid-coder on 3/10/16.
 */
public class Main {
    public static void main(String[] argc) {
        System.out.println("Main Begin...");

        TokenManagement.Put("token_a","uid");
        System.out.println("After Put, Get Token:token_a\t" + TokenManagement.Get("token_a"));
        TokenManagement.Del("token_a");
        System.out.println("After Del, Get Token:token_a\t" + TokenManagement.Get("token_a"));
        TokenManagement.Put("token_b", "uid", 10);
        System.out.println("After Put with 10s timeout, Get Token:token_b\t" + TokenManagement.Get("token_b"));
        TokenManagement.Put("token_c", "uid", 15);
        try {Thread.sleep(10*1000L);} catch(Exception e) {}

        System.out.println("10s timeout, Get Token:token_b\t" + TokenManagement.Get("token_b"));
        System.out.println("10s timeout, Get Token:token_c\t" + TokenManagement.Get("token_c"));

        System.out.println("Main End...");
    }
}
