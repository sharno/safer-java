package com.sharno.saferjava;

import javax.annotation.Nonnull;

sealed interface Status permits Pending, Shipped, Delivered {}
record Pending() implements Status {}
record Shipped(@Nonnull String carrier) implements Status {}
record Delivered(@Nonnull Long deliveryTime) implements Status {}

public class App {
    public static void main(String[] args) {
        var message = switch (getOrderStatus()) {
            case Pending p -> "The order is pending";
            case Shipped s -> String.format("Order shipped with carrier: %s", s.carrier());
            case Delivered d -> String.format("Order delivered at timestamp: %d", d.deliveryTime());
        };
        System.out.println(message);
    }

    static Status getOrderStatus() {
        return new Shipped("USPS");
    }
}
