package com.VKR;

import java.util.ArrayList;
import java.util.Collections;

public class support_func {
    public ArrayList<Double> sort(ArrayList<Double> x) {
        Collections.sort(x);
        return x;
    }

    public static double rnd() {
        return Math.random();
    }
}
