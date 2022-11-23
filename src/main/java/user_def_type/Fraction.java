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
// !!!!!!!!!!!!!!!!!!!!!!!!!! COMPLETE
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) throws Exception {
        this.numerator = numerator;
        setDenominator(denominator);
        simplifying();
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
        this.numerator=this.numerator*newDenominator>=0?Math.abs(numerator):-Math.abs(numerator);
        this.denominator = Math.abs(newDenominator);
        simplifying();
    }

    static Fraction sum(Fraction... fractions) {
        Fraction result = null;
        int accumDenom = 1;
        for (Fraction temp : fractions) {
            accumDenom *= temp.denominator;
        }
        int accumNumer = 0;
        for (Fraction temp : fractions) {
            int tempResult = accumDenom / temp.denominator;
            accumNumer += tempResult * temp.numerator;
        }
        try {
            result = new Fraction(accumNumer, accumDenom);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    static Fraction subtract(Fraction frac1, Fraction frac2) {
        Fraction result = null;
        int resultDenom = frac1.denominator * frac2.denominator;
        int resultNumerator = frac1.numerator * frac2.denominator - frac2.numerator * frac1.denominator;
        try {
            result = new Fraction(resultNumerator, resultDenom);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if (frac2.equals(new Fraction(0, 3))){
        throw new Exception("Error divide by 0 !");
    }
return  multiply(frac1, revert(frac2));
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

    @Override
    public int hashCode() {
        return Objects.hash(numerator*numerator*denominator);
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
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
