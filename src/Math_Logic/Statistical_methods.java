package Math_Logic;

import java.util.ArrayList;

import static java.lang.Math.log10;
import static java.lang.Math.sqrt;

public class Statistical_methods {

    private static double Yq = 1.282;
    private static double Y = 0.9;
    private double r;
    private int k;

    public double Point_estimate_av(ArrayList<Double> x, double t) {
        k = 0;
        double To_t = 0;
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i) <= t) {
                k += 1;
            }
        }
        for (int i = k + 1; i < x.size(); i++) {
            To_t += (x.get(i) - t) / (x.size() - k);
        }
        r = x.size() - k;
        return To_t;
    }

    public double Low_confidence_lim_av(ArrayList<Double> x, double t) {
        return Point_estimate_av(x, t) / (1 + (Yq / sqrt(r)));

    }

    public double Point_estimate_gamma(ArrayList<Double> x) {
        int m = k + 1;
        for (int i = k + 1; i < x.size(); i++) {
            if (R0(m) > Y) {
                m = i;
            }
        }
        return x.get(m) + ((x.get(m + 1) - x.get(m)) * (R0(m) - Y)) / (R0(m) - R0(m + 1));

    }

    public double R0(int m) {
        return (r - (double) m + k) / (r - k);
    }

    public double Low_confidence_lim_av(ArrayList<Double> x) {
        return Point_estimate_gamma(x) / (1 + Yq * (sqrt((1 / Y - 1) / r) / log10(1 / Y)));
    }

}
