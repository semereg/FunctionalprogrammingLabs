package com.example.lambda;

import java.util.function.Function;

public class LambdaTest {
    interface FunctionaOper {
        int operation(int a, int b);
    }

    // Performs operation on 'a' and 'b'
    private int operate(int a, int b, FunctionaOper fobj) {
        return fobj.operation(a, b);
    }

    // curring
    public static Function<Integer,
                        Function<Integer,
                             Function<Integer, Integer>> > curry() {
        return u -> w -> v -> u * w + v;
    }

    public static void main(String[] args) {
        System.out.println("Lambda testing ....");

        LambdaTest testFunc = new LambdaTest();

        // Add two numbers using lambda expression
        FunctionaOper add = (x, y) -> x + y;

        System.out.println("Addition is " + add.operation(10,20));

        System.out.println("Addition is " +
                testFunc.operate(6, 3, add));


        // Multiply two numbers using lambda expression
        FunctionaOper multiply = (int x, int y) -> x * y;

        System.out.println("Multiplication is " + multiply.operation(10,20));

        System.out.println("Multiplication is " +
                testFunc.operate(6, 3, multiply));

        /*
            Curring is multi-valued argument function into single-valued argument multi-functions.
            curry(f) = g
            Curried Function for f = u * v + w
         */
        Function<Integer, Function<Integer, Function<Integer, Integer>> >
                triAddMuli = u -> w -> v -> u * w + v;

        // Calling Curried Function for multipling u, v and Add w
        System.out.println("multiply 2, 3 and Add 4 :"
                + triAddMuli
                    .apply(2)
                    .apply(3)
                    .apply(4));

       // how is it delegating ....?
        System.out.println(triAddMuli);
        System.out.println(triAddMuli.apply(1));
        System.out.println(triAddMuli.apply(1).apply(29));
        System.out.println(triAddMuli.apply(1).apply(29).apply(21));

        int curried = curry()
                .apply(2)
                .apply(3)
                .apply(4);
        System.out.println("multiply 2, 3 and Add 4 :"
                + curried);


    }
}
