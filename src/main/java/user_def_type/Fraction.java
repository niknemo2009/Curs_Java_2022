package user_def_type;

import java.util.Objects;
import java.util.stream.IntStream;

/*
Create the class Fraction:
a) Add one or more meaningful ctors to Fraction.
b) Add methods to support meaningful arithmetic operations to Fraction.
c) Mind to create JavaDoc comments on the methods!
d) Mind to create unit tests
 */
// !!!!!!!!!!!!!!!!!!!!!!!!!! NOT COMPLETE
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) throws Exception {
        this.numerator = numerator;
        setDenominator(denominator);
        simplifying();
    }

    public static void main(String[] args) {
        //   IntStream.range(2000,100).forEach(System.out::println);
        Fraction frac1 = null;
        try {
            frac1 = new Fraction(-2, -4);
            //          System.out.println(revert(frac1));
//            Fraction frac2 = new Fraction(6, 72);
//            Fraction    frac3 = new Fraction(6,72);
//            Fraction    frac4 = new Fraction(6,8);
//            Fraction    frac5 = new Fraction(6,13);
//            System.out.println(sum(frac3,frac1,frac2));
//            subtract(frac4,frac5);
//            System.out.println("#####################");
//            System.out.println(divide(frac4,frac5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  frac1.simplifying();
        System.out.println(frac1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {

        this.numerator =numerator;
        simplifying();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int newDenominator) throws Exception {
        if (newDenominator == 0) {
            throw new Exception();
        }
        if(this.numerator*newDenominator>=0){

            this.numerator=Math.abs(numerator);
        }else{
            this.numerator=this.numerator*(-1);
        }
        this.denominator = Math.abs(newDenominator);
        simplifying();
    }

    static Fraction sum(Fraction... fractions) {
        Fraction result = null;
        int accum = 1;
        for (Fraction temp : fractions) {
            accum *= temp.denominator;
        }
        int qwe = 0;
        for (Fraction temp : fractions) {
            int a = accum / temp.denominator;
            qwe += a * temp.numerator;
        }
        try {
            result = new Fraction(qwe, accum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    static Fraction subtract(Fraction frac1, Fraction frac2) {
        Fraction result = null;
        int commonDenom = frac1.denominator * frac2.denominator;
        int resultNomerator = frac1.numerator * frac2.denominator - frac2.numerator * frac1.denominator;
        try {
            result = new Fraction(resultNomerator, commonDenom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*****************");
        System.out.println(result);
        return result;
    }

    static Fraction multiply(Fraction... fractions) {
        Fraction result = null;
        int resultNumerator = 1;
        int resultDenominator = 1;
        for (Fraction temp : fractions) {
            resultNumerator *= temp.numerator;
            resultDenominator *= temp.denominator;
        }
        try {
            result = new Fraction(resultNumerator, resultDenominator);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    static Fraction divide(Fraction frac1, Fraction frac2) throws Exception {
        Fraction result = null;
        if (frac2.equals(new Fraction(0, 3))){
throw new Exception();
    }else{
            result=multiply(frac1, revert(frac2));
        }
return  result;
}
    private static Fraction revert(Fraction frac2) {
        Fraction result=null;
        try {
            result=new Fraction(frac2.denominator, frac2.numerator);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;

        return (numerator==0 && fraction.numerator==0)||(numerator == fraction.numerator &&  denominator ==Math.abs(fraction.denominator));
    }


     void simplifying(){
        boolean isNegative=numerator*denominator<0?true:false;
        int num=Math.abs(this.numerator);

        int[] counter={2};
        while(counter[0]>1&& num!=1){
            counter[0]=0;
            IntStream.range(1,num+1).forEach(x->{
                if((this.numerator%x)==0&& this.denominator%x==0){
                    this.numerator=this.numerator/x;
                    this.denominator=this.denominator/x;
                    counter[0]++;
                } });
            num=Math.abs(this.numerator);
        }
        this.numerator=isNegative?Math.abs(this.numerator)*(-1):Math.abs(this.numerator);
        this.denominator=Math.abs(this.denominator);
              }
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
