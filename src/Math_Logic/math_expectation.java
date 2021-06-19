package Math_Logic;

import java.util.ArrayList;

import static java.lang.Math.*;

/**
 * The type Math expectation.
 */
public class math_expectation {

    private static ArrayList<Double> X = new ArrayList<>();

    /**
     * Gets x.
     *
     * @return the x
     */
    public ArrayList<Double> getX() {

        return X;
    }

    //Метод для отчистки массива в случае, если он не пустой.
    private static void Clear_X() {

        if (X.isEmpty() == false) {
            X.clear();
        }
    }

    /**
     * Math exp double.
     *
     * @param n  the sample size
     * @param MX the mathematical expectation
     * @param KV the coefficient of variation
     * @return the double
     */
    public static double Math_Exp(int n, double MX, double KV) {
        Clear_X();
        double sum = 0;
        rand_var rnd = new rand_var();
        for (int i = 0; i < n; i++) {
            X.add(rnd.Xi(MX, KV));
            sum += X.get(i);
        }
        return sum / n;

    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public static ArrayList<Double> getY() {
        ArrayList<Double> y = new ArrayList<>();
        if (X.size() > 1) {
            for (int i = 1; i < X.size() + 1; i++) {

                y.add(((double) i / (X.size() - 1)));
            }
        } else {
            y.add((double) 0);
        }
        return y;
    }

    private static double standard_deviation(int n, double MX, double KV) {
        double sum = 0;

        double ME = Math_Exp(n, MX, KV);

        for (int i = 0; i < n; i++) {

            sum += pow(X.get(i), 2);
        }
        return sqrt(abs(sum - n * pow(ME, 2)));

    }


    private static double delta(int n, double MX, double KV) {

        double zy = 1.96;
        return zy * standard_deviation(n, MX, KV) / sqrt(n);
    }

    /**
     * Lower lim double.
     *
     * @param n  the sample size
     * @param MX the mathematical expectation
     * @param KV the coefficient of variation
     * @return the double
     */
    public static double lower_lim(int n, double MX, double KV) {
        return Math_Exp(n, MX, KV) - delta(n, MX, KV);
    }

    /**
     * Upper lim double.
     *
     * @param n  the sample size
     * @param MX the mathematical expectation
     * @param KV the coefficient of variation
     * @return the double
     */
    public static double upper_lim(int n, double MX, double KV) {
        return Math_Exp(n, MX, KV) + delta(n, MX, KV);
    }


}
