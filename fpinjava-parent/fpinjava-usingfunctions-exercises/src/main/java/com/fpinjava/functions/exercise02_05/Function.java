package com.fpinjava.functions.exercise02_05;

public interface Function<T, U> {

  U apply(T arg);



  static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose(){
    return f1 -> f2 -> arg -> f1.apply(f2.apply(arg));
  }


    static  Function<Function<String, Boolean>, Function<Function<Integer, String>, Function<Integer, Boolean>>> higherCompose4(){
        return f1 -> f2 -> arg -> f1.apply(f2.apply(arg));
    }

    //F0 - Boolean T
    //F1 - Integer U
    //F2 - Boolean V
    //Arg - Character W

  static <T> Function<Function<T, T>, Function<T, T>> higherCompose2(){
    return f1 -> arg -> f1.apply(arg);
  }

  static <T> Function<T, Integer> higherCompose3(){
    final Function<T, Integer> tIntegerFunction = arg -> 0;
    return tIntegerFunction;
  }

//  static <T, U, V> Function<> higherCompose2() {
//    return x -> y -> z -> x.apply(y.apply(z));
//  }
//
//  static <T, U, V> Function<T, Function<>> higherCompose2() {
//    return x -> y -> z -> x.apply(y.apply(z));
//  }
//
//  static <T, U, V> Function<Function<>, Function<>> higherCompose2() {
//    return x -> y -> z -> x.apply(y.apply(z));
//  }
//
//  static <T, U, V> Function<Function<>, Function<Function<>, Function<>>> higherCompose2() {
//    return x -> y -> z -> x.apply(y.apply(z));
//  }
}
