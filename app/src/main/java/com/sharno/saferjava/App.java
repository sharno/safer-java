package com.sharno.saferjava;

import javax.annotation.Nonnull;

record Person(@Nonnull String name, int age) {}

sealed interface Response permits Success, Failure {}
record Success(@Nonnull Person person) implements Response {}
record Failure(@Nonnull String error) implements Response {}

public class App {
    static Response getData() {
        return new Success(new Person("Mohamed", 20));
    }

    public static void main(String[] args) {
        var x = switch (getData()) {
            case Success s-> "";
            case Failure f -> "";
        };
    }
}
