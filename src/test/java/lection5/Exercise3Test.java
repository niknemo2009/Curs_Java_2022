package lection5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Exercise3Test {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void copyValuesTest(int[] values, int[] arr,int[] expectedResult) {
    assertArrayEquals(Exercise3.copyValues(values,arr),expectedResult);
    }
    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new  int[]{1,2,3},new  int[]{4,5,6,7},new  int[]{1,2,3,7}),
                Arguments.of(new  int[]{1,2,3},new  int[]{4,5,6},new  int[]{1,2,3}),
                Arguments.of(new  int[]{1,2,3},new  int[]{4,5},new  int[]{1,2}),
                Arguments.of(new  int[]{},new  int[]{4,5,6,7},new  int[]{4,5,6,7}),
                Arguments.of(new  int[]{1,2},new  int[]{},new  int[]{})
        );
    }
}