package com.fpinjava.functions.exercise02_01;

public class HigherComposeOptions <T, U, V> {

    //using params
    public static <T, U, V> Function<T, V> higherCompose1(Function<U, V> f1, Function<T, U> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }

    //using params of the lambda
    public final TriFunction<Function<U, V>, Function<T, U>, T, V>
            higherCompose3 = (f1, f2, arg) -> f1.apply(f2.apply(arg));


    //currying
    public static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose3() {
        return f1 -> f2 -> arg -> f1.apply(f2.apply(arg));
    }

}
