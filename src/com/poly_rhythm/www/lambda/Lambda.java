package com.poly_rhythm.www.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        OneParam oneParam = System.out::println;
        oneParam.hoge("param");

        MultiParam multiParam = (param1, param2) -> System.out.println(param1 + param2);
        multiParam.hoge("param1", "param2");

        lambda.hoge2();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        // Stream
        boolean allMatch = list.stream().allMatch(Lambda::isEven);
        System.out.println("allMatch:" + allMatch);

        boolean anyMatch = list.stream().anyMatch(Lambda::isEven);
        System.out.println("anyMatch:" + anyMatch);

        boolean noneMatch = list.stream().noneMatch(Lambda::isEven);
        System.out.println("noneMatch:" + noneMatch);

        IntStream.rangeClosed(0, 99).boxed().filter(Lambda::isEven).parallel().forEach(i -> System.out.println("filtered:" + i));

        IntStream.rangeClosed(0, 99).boxed().map(i -> i % 2).distinct().forEach(i -> System.out.println("distinct:" + i));

        IntStream.rangeClosed(0, 99).boxed().collect(Collectors.groupingBy(i -> i % 2)).forEach((a, b) -> System.out.println("a:" + a + " b:" + b));



    }

    private static boolean isEven(Integer integer) {
        return integer % 2 == 0;
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
