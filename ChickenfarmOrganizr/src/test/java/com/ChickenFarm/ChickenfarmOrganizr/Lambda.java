package com.ChickenFarm.ChickenfarmOrganizr;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambda {

    @Test
    void simpleLambdaExecution() {
        Function<Integer, Integer> doubleIt =
                (x) // Argumente meiner Funktion
                -> { // mache mit den Argumenten Folgendes:
                    return 2 * x; // Ausführung
                };

        assert 8 == apply(y -> y * 2, 4);
        assert 'c' == apply(c -> c, 'c');
    }


    private <T> T apply(Function<T, T> fun, T t) {
        return fun.apply(t);
    }

    private int timesTwo(int x) {
        return 2 * x;
    }

    private int timesTwo(int x, int j) {
        return 2 * x;
    }

    @Test
    void advancedLambdaExecution() {
        assert 16 == apply(
                this::timesTwo,
                apply( // == 8
                        x -> timesTwo(x),
                        4
                )
        );
    }



    @Test
    void testBi() {
        applyBi(this::add, 1, 2);
        applyBi((a, b) -> {
                    a *= 3;
                    b -= 4;
                    int x = a * b;
                    return x / 2;
                },
                3, 9);

    }





    private int applyBi(BiFunction<Integer, Integer, Integer> fun, int x1, int x2) {
        return fun.apply(x1, x2);
    }

    private int add(int a, int b) {
        return a + b;
    }

    @Test
    void ALisLamdaExecution() {
        
    }




}


