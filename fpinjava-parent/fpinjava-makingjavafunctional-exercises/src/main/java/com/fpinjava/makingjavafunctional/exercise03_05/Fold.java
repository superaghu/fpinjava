package com.fpinjava.makingjavafunctional.exercise03_05;

import com.fpinjava.common.Function;

import java.util.List;

public class Fold {

    public static Integer fold(List<Integer> is, Integer identity,
                               Function<Integer, Function<Integer, Integer>> f) {
        Integer result = identity;
        for (Integer item : is) {
            result = f.apply(result).apply(item);
        }
        return result;
    }
}
