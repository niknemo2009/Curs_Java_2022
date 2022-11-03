package lection5;

import java.util.Arrays;

/*
3) Create a method that accepts at least two array arguments. The method should copy
the content of one array into the other array.
a) Write a test program to test your method.
b) Which error cases do you need to handle in this method?
 */

// !!!!!!!!!!!!!!!!!!!!!!!!!!!! COMPLETE
public class Exercise3 {

    public static void main(String[] args) {
        copyValues(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7});
    }

    static int[] copyValues(int[] values, int[] arr2) {
        int[] result = Arrays.copyOf(arr2, arr2.length);
        for (int i = 0; i < result.length; i++) {
            if (values.length > i) {
                result[i] = values[i];
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}

