package Math_Logic;

import java.math.BigDecimal;
import java.util.Formatter;

import static java.lang.Math.*;

public class BS {
    public static double BS(double a, double b){
        math_expectation ME = new math_expectation();
       double Zq = -1.28;
        return (2*a*b+pow(Zq,2)+Zq*sqrt(4*a*b+pow(Zq,2)))/(2*pow(b,2));
    }
}
