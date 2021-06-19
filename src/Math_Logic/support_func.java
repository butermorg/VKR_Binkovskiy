package Math_Logic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Support func.
 */
public class support_func {
    /**
     * Sort array list.
     *
     * @param x the sampling of developments
     * @return array list
     */
    public ArrayList<Double> sort(ArrayList<Double> x) {

        Collections.sort(x);
        return x;
    }

    /**
     * Rnd double.
     *
     * @return the double
     */
    public static double rnd() {

        return Math.random();
    }
}
