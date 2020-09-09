package com.fpinjava.makingjavafunctional.exercise03_01_mine;

import com.fpinjava.common.Function;

import java.util.regex.Pattern;

public class EmailValidation {
    static Pattern pattern = Pattern.compile("^[a-zA-Z0-9.-]+@[a-zA-Z.-]+\\.[a-z]{2,4}$");

    static Function<String, Result<String>> valid = s -> {
        if (s == null) {
            return  Result.failure("email must not be null");
        } else if (s.length() == 0) {
            return  Result.failure("email must not be empty");
        } else if (pattern.matcher(s).matches()) {
            return  Result.success(s);
        } else {
            return  Result.failure("email " + s + " is invalid.");
        }
    };

    public static void main(String... args) {
        validate().apply("this.is@my.email").bind(success, failure);
        validate().apply(null).bind(success, failure);
        validate().apply("").bind(success, failure);
        validate().apply("john.doe@acme.com").bind(success, failure);
    }

    private static Function<String, Result<String>> validate() {
       return valid;
    }

    private static void logError(String s) {
        System.err.println("Error message logged: " + s);
    }
    private static void sendVerificationMail(String s) {
        System.out.println("Mail sent to " + s);
    }

    static Effect<String> failure = EmailValidation::logError;
    static Effect<String> success = EmailValidation::sendVerificationMail;
}
