package com.fpinjava.makingjavafunctional.exercise03_02_mine;

import com.fpinjava.common.Result;
import com.fpinjava.common.Tuple;

public class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>> {
    public Case(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
        super(booleanSupplier, resultSupplier);
    }

    public static <T> Case<T> mcase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
        return new Case<T>(condition, value);
    }

    public static <T> DefaultCase<T> mcase(Supplier<Result<T>> value) {
        return new DefaultCase<T>(value);
    }

    public static class DefaultCase<T> extends Case<T> {
        public DefaultCase(Supplier<Result<T>> resultSupplier) {
            super(() -> true, resultSupplier);
        }
    }

    public static <T> Result<T> match(DefaultCase<T> defaultCase, Case<T>... values) {
        for (Case<T> mcase : values) {
            if (mcase._1.get()) {
                return mcase._2.get();
            }
        }
        return defaultCase._2.get();
    }
}
