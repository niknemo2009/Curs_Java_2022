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
    void checkSum(Fraction[] data, Fraction result) {
        assertEquals(Fraction.sum(data),result);
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
    @Test
    void subtract() {
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