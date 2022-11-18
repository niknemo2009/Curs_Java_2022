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
    void getNumerator() {
    }

    @Test
    void setNumerator() {
    }

    @Test
    void getDenominator() {
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
                Arguments.of(new Fraction[]{new Fraction(1,-3),new Fraction(1,3)},new Fraction(2,3))

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
                Arguments.of(new Fraction(2,5),new Fraction(1,10),new Fraction(3,5)),
                Arguments.of(new Fraction(2,5),new Fraction(1,5),new Fraction(1,5)),
                Arguments.of(new Fraction(2,5),new Fraction(3,5),new Fraction(-1,5)),
                Arguments.of(new Fraction(22,1),new Fraction(4,2),new Fraction(20,1)),
                Arguments.of(new Fraction(20,5),new Fraction(40,10),new Fraction(0,10)),
                Arguments.of(new Fraction(20,5),new Fraction(40,10),new Fraction(0,77)),
                Arguments.of(new Fraction(2,11),new Fraction(4,9),new Fraction(-26,99))

        );
    }
    @Test
    void multiply() {
    }

    @Test
    void divide() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void simplifying() {
    }

    @Test
    void testHashCode() {
    }


}