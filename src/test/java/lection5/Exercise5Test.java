package lection5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise5Test {

    @Test
    void shuffle() {
        Exercise5 ex = new Exercise5();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedResult = {1, 2, 3, 4, 5, 6, 9, 8, 7};
        ex.shuffle(arr);
        assertEquals(isCompareArrays(arr, expectedResult), true);


    }

    private boolean isCompareArrays(int[] arr1, int[] arr2) {
        boolean result = true;
        if (arr1.length != arr2.length) {
            return false;
        }
        int[] copy1 = Arrays.copyOf(arr1, arr1.length);
        int[] copy2 = Arrays.copyOf(arr2, arr2.length);
        Arrays.sort(copy1);
        Arrays.sort(copy2);
        for (int i = 0; i < copy1.length; i++) {
            if (copy1[i] != copy2[i]) {
                return false;
            }
        }
        return result;
    }
}