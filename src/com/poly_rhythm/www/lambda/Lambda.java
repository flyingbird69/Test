package com.poly_rhythm.www.lambda;

/**
 * Lambda
 *
 * Created by flyingbird69 on 11/30/15.
 */
public class Lambda {

    private String hoge;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        String str = "string";

        Itfc itfc = () -> System.out.println(str);

        itfc.hoge();
//        System.out.println("executed hoge");
//
//        itfc.page();
//        System.out.println("executed page");

        Lambda lambda = new Lambda();
        lambda.hoge = "this";
        lambda.hoge();

        OneParam oneParam = param -> System.out.println(param);
        oneParam.hoge("param");

        MultiParam multiParam = (param1, param2) -> System.out.println(param1 + param2);
        multiParam.hoge("param1", "param2");

        lambda.hoge2();

    }

    private void hoge() {

        Itfc itfc = () -> System.out.println(this.hoge);

        itfc.hoge();

    }

    private void hoge2() {

        Counter i = new Counter();
        Itfc itrc = () -> System.out.println(i.next());
        for (int j = 0; j < 100; j++) {
            itrc.hoge();
        }

    }

    private class Counter {
        private int i =0;
        public int next() {
            return this.i++;
        }
    }

    /**
     *
     */
    @FunctionalInterface
    public interface Itfc {
        void hoge();
//        void page();
    }

    public interface OneParam {
        void hoge(String string);
    }

    public interface MultiParam {
        void hoge(String string1, String string2);
    }

}
