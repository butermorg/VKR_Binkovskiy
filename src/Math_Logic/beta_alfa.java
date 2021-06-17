package Math_Logic;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class beta_alfa {

    public double beta(double MX, double KV) {
        return (1 / KV) * sqrt((1 + sqrt(1 + 3 * pow(KV, 2))) / 2 * MX);
    }

    public double alfa(double MX, double KV) {
        double b = beta(MX, KV);
        return b * MX - (0.5 / b);
    }
}
