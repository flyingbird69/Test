package com.poly_rhythm.www.generics;

import java.math.BigDecimal;

/**
 * Generics
 *
 * Created by flyingbird69 on 11/30/15.
 */
public class Generics {

    public static void main(String[] args) {
        new Generics().hoge("String");
        new Generics().hoge(BigDecimal.ZERO);

    }

    private <T> void hoge(T hoge) {
        System.out.println(hoge);
    }

}
