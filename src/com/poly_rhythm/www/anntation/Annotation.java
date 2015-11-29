package com.poly_rhythm.www.anntation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Annotation
 *
 * Created by flyingbird69 on 11/30/15.
 */
public class Annotation {

    private Annotation() {
        super();
    }

    public static void main(String[] args) {
        Annotation main = new Annotation();
        main.execute(main, args);
    }

    @Finalizer
    public void hoge1(Object arg) {
        System.out.println("hoge1");
    }

    @MainLogic
    public void hoge2(Object arg) {
        System.out.println("hoge2");
    }

    @Initializer
    public void hoge3(Object arg) {
        System.out.println("hoge3");
    }

    private void execute(Object targetObExecution, Object arg) {

        Method[] methods = targetObExecution.getClass().getMethods();

        Method initializer = null;
        Method mainlogic = null;
        Method finalizer = null;

        for (Method method : methods) {
            Initializer i = method.getAnnotation(Initializer.class);
            if (null != i) {
                if (null != initializer) {
                    throw new RuntimeException("Initializer duplicated");
                }
                initializer = method;
            }
            MainLogic m = method.getAnnotation(MainLogic.class);
            if (null != m) {
                if (null != mainlogic) {
                    throw new RuntimeException("MainLogic duplicated");
                }
                mainlogic = method;
            }
            Finalizer f = method.getAnnotation(Finalizer.class);
            if (null != f) {
                if (null != finalizer) {
                    throw new RuntimeException("Finalizer duplicated");
                }
                finalizer = method;
            }
        }

        try {
            if (null != initializer) {
                System.out.println("start initializer");
                initializer.invoke(this, arg);
                System.out.println("end initializer");
            }
            if (null != mainlogic) {
                System.out.println("start mainlogic");
                mainlogic.invoke(this, arg);
                System.out.println("end mainlogic");
            }
            if (null != finalizer) {
                System.out.println("start finalizer");
                finalizer.invoke(this, arg);
                System.out.println("end finalizer");
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
