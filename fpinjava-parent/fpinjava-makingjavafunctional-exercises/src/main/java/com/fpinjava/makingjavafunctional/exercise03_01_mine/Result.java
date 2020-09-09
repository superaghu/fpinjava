package com.fpinjava.makingjavafunctional.exercise03_01_mine;

public interface Result<T> {
    public void bind(Effect<T> success, Effect<String> failure);

    public static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    public static <T> Result<String> failure(String message) {
        return new Failure<>(message);
    }

    class Success<T> implements Result<T> {
        private T value;

        private Success(T value) {
            this.value = value;
        }

        @Override
        public void bind(Effect<T> success, Effect<String> failure) {
            success.exec(value);
        }
    }

    class Failure<T> implements Result<T> {
        public String getMessage() {
            return message;
        }

        @Override
        public void bind(Effect<T> success, Effect<String> failure) {
            failure.exec(message);
        }

        private final String message;

        public Failure(String message) {
            this.message = message;
        }
    }
}
