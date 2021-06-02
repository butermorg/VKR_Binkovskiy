package Math_Logic;

import java.math.BigDecimal;
import java.util.ArrayList;

import static java.lang.Math.*;

public class math_expectation {
    private static double Zy=1.96;
    private static ArrayList<Double> X = new ArrayList<>();

    public static double getZy() {
        return Zy;
    }

    public ArrayList<Double> getX() {
        return X;
    }
    private static void Clear_X(){
        if(X.isEmpty()==false){
            X.clear();
        }
    }

    public static double Math_Exp(int n, double MX, double KV){
        Clear_X();
        double sum = 0;
        rand_var rnd = new rand_var();
        for(int i=0;i<n;i++){
            X.add(rnd.Xi(MX,KV));
            sum+= X.get(i);
        }
        return sum/n;

    }

    private static double standard_deviation(int n,double MX,double KV){
    double sum = 0;

    double ME = Math_Exp(n,MX,KV);

            for (int i = 0; i < n; i++) {
                //sum += this.X.get(i); возможно ошибка
                sum += pow(X.get(i),2);
            }
        return sqrt(abs(sum-n*pow(ME,2)));

    }


    private static double delta(int n,double MX, double KV){

return Zy*standard_deviation(n,MX,KV)/sqrt((double) n) ;
    }

    public static double lower_lim(int n,double MX,double KV){
        return Math_Exp(n,MX,KV)-delta(n,MX,KV);
    }

    public static double upper_lim(int n,double MX,double KV){
        return Math_Exp(n,MX,KV)+delta(n,MX,KV);
    }




}
