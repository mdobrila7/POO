package com.oop_pub.exceptions.ex2_3;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainEx2 {
    public static void main(String[] args) {
        Calculator calculator = new DoubleCalculator();

        System.out.println(calculator.add(2d, 3d));
        System.out.println(calculator.divide(9d, 4d));
        System.out.println(calculator.average(List.of(1d, 2d, 3d, 4d)));

//        System.out.println(calculator.add(null, 2d));
//        System.out.println(calculator.add(Double.POSITIVE_INFINITY, 0d));
//        System.out.println(calculator.add(Double.NEGATIVE_INFINITY, 0d));

//        System.out.println(calculator.divide(null, 2d));
//        System.out.println(calculator.divide(2d, 0d));
//        System.out.println(calculator.divide(Double.POSITIVE_INFINITY, 0d));
//        System.out.println(calculator.divide(Double.NEGATIVE_INFINITY, 0d));

    }
}
