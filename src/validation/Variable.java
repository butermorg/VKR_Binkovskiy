package validation;

import static java.lang.Math.abs;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Variable
{

    public float f_var(String text)
    {
        System.out.print("input float number "+text+": ");
        Scanner sc = new Scanner(System.in);
        String a=sc.next();
        int i=4;
        while(this.f_valid(a).equals("error"))
        {
            if(i>0)
            {  // System.out.println(i+" attempts left");
                i--;

            }
            else
            {
                System.out.println("Attempt is over, please read the user instructions and try again");
                System.exit(1);
            }
            System.out.printf("error number not found, input new number %s (attempts left %d): ",text,i);
            a=sc.next();

        }


        if(abs(Float.parseFloat(this.f_valid(a)))>Float.MAX_VALUE)
        {
            text = Float.parseFloat(this.f_valid(a))>0 ? Float.toString(Float.MAX_VALUE) : Float.toString(Float.MIN_VALUE);
            return Float.parseFloat(text);
        }

        return Float.parseFloat(this.f_valid(a));


    }
    public String f_valid(String text)
    {
        if(text.indexOf(".") == - 1)
        {
            text+=".0";
        }

        Pattern pattern = Pattern.compile("[-+]?([0-9]*[.])?[0-9]+([eE][-+]?\\d+)?");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find())
        {
            // System.out.println(text.substring(matcher.start(), matcher.end()));
            return text.substring(matcher.start(), matcher.end());
        }
        else
        {
            return "error";
        }
    }
    public float i_var(String text)
    {
        System.out.print("input int number "+text+": ");
        Scanner sc = new Scanner(System.in);
        String a=sc.next();
        int i=4;
        while(this.i_valid(a).equals("error"))
        {
            if(i>0)
            {  // System.out.println(i+" attempts left");
                i--;

            }
            else
            {
                System.out.println("Attempt is over, please read the user instructions and try again");
                System.exit(1);
            }
            System.out.printf("error number not found, input new number %s (attempts left %d): ",text,i);
            a=sc.next();

        }


        if(abs(Integer.parseInt(this.i_valid(a)))>Integer.MAX_VALUE)
        {
            text = Integer.parseInt(this.i_valid(a))>0 ? Integer.toString(Integer.MAX_VALUE) : Integer.toString(Integer.MIN_VALUE);
            return Integer.parseInt(text);
        }

        return Integer.parseInt(this.i_valid(a));


    }
    public String i_valid(String text)
    {

        Pattern pattern = Pattern.compile("[-0-9]+");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find())
        {
            // System.out.println(text.substring(matcher.start(), matcher.end()));
            String a = text.substring(matcher.start(), matcher.end());
            if (a.length()>5){
                return a.substring(0,5);}
            else return a;
        }
        else
        {
            return "error";
        }
    }


}