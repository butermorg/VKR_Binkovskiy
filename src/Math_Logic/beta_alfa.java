package Math_Logic;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * The type Beta alfa.
 */
public class beta_alfa {

    /**
     * Beta double.
     *
     * @param MX the mx
     * @param KV the kv
     * @return double
     */
    //getting a beta number
    public double beta(double MX, double KV) {
        return (1 / KV) * sqrt((1 + sqrt(1 + 3 * pow(KV, 2))) / 2 * MX);
    }

    /**
     * Alfa double.
     *
     * @param MX the mx
     * @param KV the kv
     * @return the double
     */
    //getting a alfa number
    public double alfa(double MX, double KV) {
        double b = beta(MX, KV);
        return b * MX - (0.5 / b);
    }
}
