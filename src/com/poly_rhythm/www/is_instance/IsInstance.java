package com.poly_rhythm.www.is_instance;

import java.util.ArrayList;
import java.util.List;

/**
 * IsInstance
 *
 * Created by flyingbird on 12/8/15.
 */
public class IsInstance {

    /**
     *
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        hoge(String.class, "");
        hoge(String.class, new Object());

        hoge(List.class, new ArrayList());

        hoge(Object.class, new ArrayList());

    }

    private static void hoge(Class tClass, Object object) {

        if (tClass.isInstance(object)) {
            System.out.println("isInstance");
        } else {
            System.out.println("isNotInstance");
        }

    }

}
