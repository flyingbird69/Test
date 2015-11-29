package com.poly_rhythm.www.lambda;

/**
 * Lambda
 *
 * Created by flyingbird69 on 11/30/15.
 */
public class Lambda {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        Itfc itfc = () -> {
            System.out.println("hoge");
        };

        itfc.hoge();
//        System.out.println("executed hoge");
//
//        itfc.page();
//        System.out.println("executed page");
    }

    /**
     *
     */
    @FunctionalInterface
    public interface Itfc {
        void hoge();
//        void page();
    }

}
