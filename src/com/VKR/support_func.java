package com.VKR;

import Math_Logic.math_expectation;

import java.util.ArrayList;
import java.util.Collections;

public class support_func {
    public ArrayList<Double> Xsort() {
        ArrayList<Double> x;
        math_expectation me = new math_expectation();
        x = me.getX();
        Collections.sort(x);
        return x;
    }

    public static double rnd() {
        return Math.random();
    }
}
