package Math_Logic;

import java.util.ArrayList;

import static com.VKR.support_func.rnd;
import static java.lang.Math.ceil;

public class math_expectation_distr_func {
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

    public ArrayList<Double> sample_dev(ArrayList<Double> x) {
        double gamma = 0.9;
        ArrayList<Double> t = new ArrayList<>();
        for (int i = 0; i < x.size() - 1; i++) {
            double r = rnd();
            t.add(x.get(i) + ((x.size() - 1) * r - ceil((1 - gamma) * (x.size() - 1)) + 1) * (x.get(i + 1) - x.get(i)));

        }

        return t;
    }
}
