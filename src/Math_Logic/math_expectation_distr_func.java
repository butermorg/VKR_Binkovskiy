package Math_Logic;

import java.util.ArrayList;

import static Math_Logic.support_func.rnd;
import static java.lang.Math.ceil;

/**
 * The type Math expectation distr func.
 */
public class math_expectation_distr_func {
    /**
     * Xn double.
     *
     * @param x the sampling of developments
     * @param y the gamma
     * @return double
     */
    public Double Xn(ArrayList<Double> x, ArrayList<Double> y) {
        double ME_Xn = 0;
        for (int i = 0; i < x.size(); i++) {
            if (i + 1 < x.size()) {
                ME_Xn += 0.5 * ((2 - y.get(i + 1) - y.get(i)) * (x.get(i + 1) - x.get(i)));
            }
        }
        ME_Xn += x.get(0);

        return ME_Xn;
    }

    /**
     * Sample dev array list.
     *
     * @param x the sampling of developments
     * @return the array list
     */
    public ArrayList<Double> sample_dev(ArrayList<Double> x) {
        double gamma = 0.9;
        ArrayList<Double> t = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            double r = rnd();
            double j = ceil(r*(x.size()-2));
            t.add(x.get((int)j) + ((r*((double) x.size()-1))-j+1) * (x.get((int)j + 1) - x.get((int)j)));

        }

        return t;
    }
}
