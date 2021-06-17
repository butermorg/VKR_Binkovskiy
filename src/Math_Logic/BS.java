package Math_Logic;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


/*гамма процентный ресурс*/
public class BS {
    public static double BS(double a, double b) {
        math_expectation ME = new math_expectation();
        /*квантиль нормированного нормального закона при q=1-𝛾*/
        double Zq = -1.28;
        return (2 * a * b + pow(Zq, 2) + Zq * sqrt(4 * a * b + pow(Zq, 2))) / (2 * pow(b, 2));
    }
}
