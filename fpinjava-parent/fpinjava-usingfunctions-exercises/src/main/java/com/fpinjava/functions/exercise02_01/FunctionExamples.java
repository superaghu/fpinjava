package com.fpinjava.functions.exercise02_01;

public class FunctionExamples {

    public static final Function<Integer, Integer> triple() {
        return
                new Function<Integer, Integer>() {

                    @Override
                    public Integer apply(Integer arg) {
                        return arg * 3;
                    }
                };
    }

    public static final Function<Integer, Integer> triple2 = arg -> arg * 3;

    public static final Function<Integer, Integer> square() {
        return new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer arg) {
                return arg * arg;
            }
        };
    }

    public static final Function<Integer, Integer> square2 = arg -> arg * arg;

    public static final Function<Integer, Integer> compose(final Integer x, final Integer y) {
        return arg -> x + y;
    }


    public static final Function<Integer, Integer> compose(final Function<Integer, Integer> x, final Function<Integer, Integer> y) {
        return arg -> x.apply(y.apply(arg));
    }


    //public static final TriFunction<Function<>, Function, Function, Integer> compose2 =  f1 -> f2 -> arg -> f1.apply(f2.apply(arg));
    public static final TriFunction<Function<Integer, Integer>, Function<Integer, Integer>, Integer, Integer> compose3 =  (f1, f2, arg) -> f1.apply(f2.apply(arg));

    public static final TriFunction<Integer, Integer, Integer, Integer> compose4 =  (f1, f2, arg) -> f1 + 0;


    public static final Function<Integer, Integer> compose2(Function f1, Function f2) { return arg -> triple2.apply(square2.apply(arg));};

    public static final Function<Integer, Integer> compose201(Function<Integer, Integer> f1, Function<Integer, Integer> f2) { return arg -> f1.apply(f2.apply(arg));};

    public static final TriFunction<Function<Integer, Integer>, Function<Integer, Integer>, Integer, Integer> compose301 =  (f1, f2, arg) -> f1.apply(f2.apply(arg));

}
