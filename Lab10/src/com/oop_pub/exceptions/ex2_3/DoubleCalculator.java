package com.oop_pub.exceptions.ex2_3;

import java.util.Collection;

public class DoubleCalculator implements Calculator {
    @Override
    public Double add(Double nr1, Double nr2) throws NullParameterException, OverflowException, UnderflowException {
        if (nr1 == null|| nr2 == null)
            throw new NullParameterException();

        Double sum = nr1 + nr2;

        if (sum == Double.POSITIVE_INFINITY)
            throw new OverflowException();

        if (sum == Double.NEGATIVE_INFINITY)
            throw new UnderflowException();

        return sum;
    }

    @Override
    public Double divide(Double nr1, Double nr2) throws NullParameterException, OverflowException, UnderflowException {
        if (nr1 == null || nr2 == null || nr2 == 0)
            throw new NullParameterException();

        Double result = nr1 / nr2;

        if (result == Double.POSITIVE_INFINITY)
            throw new OverflowException();

        if (result == Double.NEGATIVE_INFINITY)
            throw new UnderflowException();

        return result;
    }

    @Override
    public Double average(Collection<Double> numbers) {;
        Double sum = 0d;
        for (Double number: numbers) {
            sum = add(sum, number);
        }
        Double avg = divide(sum, (double) numbers.size());
        return avg;
    }
}
