package Math_Logic;

import static com.VKR.support_func.rnd;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class rand_var {



    private static double Z() {

        double sum = 0;
        for (int i = 1; i <= 12; i++) {
            sum += rnd();
        }
        return sum - 6;
    }
    /*Алгоритм моделирования случайной величины*/
    public static double Xi(double MX, double KV) {
        beta_alfa var = new beta_alfa();
        double a = var.alfa(MX, KV);
        double b = var.beta(MX, KV);
        double z = Z();
        return (a / b) + 0.5 * (pow(z / b, 2)) + (z / b) * sqrt((a / b) + 0.25 * (pow(z, 2) / b));

    }

}
