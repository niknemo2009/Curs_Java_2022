package user_def_type;

import lection5.Exercise3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void getNumerator() throws Exception {
        Fraction frac1=new Fraction(4,36);
        assertEquals(frac1.getNumerator(),1);
        Fraction frac2=new Fraction(-4,36);
        assertEquals(frac2.getNumerator(),-1);
        Fraction frac3=new Fraction(4,-36);
        assertEquals(frac3.getNumerator(),-1);
        Fraction frac4=new Fraction(-4,-36);
        assertEquals(frac4.getNumerator(),1);
    }

    @Test
    void setNumerator() throws Exception {
        Fraction frac1=new Fraction(5,36);
        frac1.setNumerator(2);
         assertEquals(frac1,new Fraction(1,18));
        Fraction frac2=new Fraction(-7,36);
        frac2.setNumerator(9);
        assertEquals(frac2,new Fraction(-1,4));
        Fraction frac3=new Fraction(4,-36);
        frac3.setNumerator(18);
        assertEquals(frac3,new Fraction(-2,1));
        Fraction frac4=new Fraction(-4,-36);
        frac4.setDenominator(18);
        assertEquals(frac4,new Fraction(10,5));
    }

    @Test
    void getDenominator() throws Exception {
        Fraction frac1=new Fraction(4,36);
        assertEquals(frac1.getDenominator(),9);
        Fraction frac2=new Fraction(-4,36);
        assertEquals(frac2.getDenominator(),9);
        Fraction frac3=new Fraction(4,-36);
        assertEquals(frac3.getDenominator(),9);
        Fraction frac4=new Fraction(-4,-36);
        assertEquals(frac4.getDenominator(),9);
    }

    @Test
    void setDenominator() {
    }

    @ParameterizedTest
    @MethodSource("sumProvider")
    void checkSum(Fraction[] data, Fraction expectedResult) {
        assertEquals(Fraction.sum(data),expectedResult);
    }
    static Stream<Arguments> sumProvider() throws Exception {
        return Stream.of(
                Arguments.of(new Fraction[]{},new Fraction(0,1)),
                Arguments.of(new Fraction[]{new Fraction(1,3),new Fraction(1,3)},new Fraction(2,3)),
                Arguments.of(new Fraction[]{new Fraction(6,36),new Fraction(5,7)},new Fraction(37,42)),
                Arguments.of(new Fraction[]{new Fraction(-1,3),new Fraction(1,3)},new Fraction(0,3)),
                Arguments.of(new Fraction[]{new Fraction(-1,-3),new Fraction(1,3)},new Fraction(2,3)),
                Arguments.of(new Fraction[]{new Fraction(1,-3),new Fraction(1,3)},new Fraction(0,3))

        );
    }
    @ParameterizedTest
    @MethodSource("substractProvider")
    void checkSubtract(Fraction frac1,Fraction frac2, Fraction expectedResult ) {
        assertEquals(Fraction.subtract(frac1,frac2),expectedResult);

    }
    static Stream<Arguments> substractProvider() throws Exception {
        return Stream.of(
                Arguments.of(new Fraction(2,5),new Fraction(4,10),new Fraction(0,50)),
                Arguments.of(new Fraction(2,5),new Fraction(1,10),new Fraction(3,10)),
                Arguments.of(new Fraction(2,5),new Fraction(1,5),new Fraction(1,5)),
                Arguments.of(new Fraction(2,5),new Fraction(3,5),new Fraction(-1,5)),
                Arguments.of(new Fraction(22,1),new Fraction(4,2),new Fraction(20,1)),
                Arguments.of(new Fraction(20,5),new Fraction(40,10),new Fraction(0,10)),
                Arguments.of(new Fraction(20,5),new Fraction(40,10),new Fraction(0,77)),
                Arguments.of(new Fraction(2,11),new Fraction(4,9),new Fraction(-26,99))

        );
    }
    @ParameterizedTest
    @MethodSource("multiplyProvider")
    void checkMultiply(Fraction[] data, Fraction expectedResult) {
        assertEquals(Fraction.multiply(data),expectedResult);
    }
    static Stream<Arguments> multiplyProvider() throws Exception {
        return Stream.of(
                Arguments.of(new Fraction[]{new Fraction(2,5),new Fraction(4,10)},new Fraction(4,25)),
                Arguments.of(new Fraction[]{new Fraction(2,5),new Fraction(0,10)},new Fraction(0,10)),
                Arguments.of(new Fraction[]{new Fraction(-2,5),new Fraction(-1,5)},new Fraction(2,25))
        );
    }
    @ParameterizedTest
    @MethodSource("divideProvider")
    void checkDivide() {

    }
    static Stream<Arguments> divideProvider() throws Exception {
        return Stream.of(
                Arguments.of(new Fraction[]{new Fraction(2,5),new Fraction(4,10)},new Fraction(5,5)),
                Arguments.of(new Fraction[]{new Fraction(2,5),new Fraction(0,10)},new Fraction(0,10)),
                Arguments.of(new Fraction[]{new Fraction(-2,5),new Fraction(-1,5)},new Fraction(2,25))
        );
    }
    @Test
    void testEquals() {
    }



    @Test
    void testHashCode() {
    }


}