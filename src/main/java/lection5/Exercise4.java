package lection5;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
4) Write a method, which concatenates two arrays.
a) A solution implemented with loops.
b) A solution with the companion class Arrays
 */
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! COMPLETE
public class Exercise4 {

    public static void main(String[] args) {
        Exercise4 ex = new Exercise4();
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] arr3 = {7, 8};
        System.out.println(Arrays.toString(ex.concatArray1(arr1, arr2, arr3)));
        System.out.println(Arrays.toString(ex.concatArray2(arr1, arr2, arr3)));
        System.out.println(Arrays.toString(ex.concatArray3(arr1, arr2, arr3)));
        System.out.println(Arrays.toString(ex.concatArray1()));
        System.out.println(Arrays.toString(ex.concatArray2()));
        System.out.println(Arrays.toString(ex.concatArray3()));
    }

    int[] concatArray1(int[]... arrays) {
        int totalCount = getTotalCount(arrays);
        int[] result = new int[totalCount];
        int counter = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int temp : arrays[i]) {
                result[counter] = temp;
                counter++;
            }

        }
        return result;
    }

    int[] concatArray2(int[]... arrays) {
        List<Integer> result = new Vector<>();
        int counter = 0;
        for (int[] temp : arrays) {
            result.addAll(Arrays.stream(temp).boxed().collect(Collectors.toList()));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    int[] concatArray3(int[]... arrays) {
        int[] result = Arrays.stream(arrays).flatMapToInt(arr -> IntStream.of(arr)).toArray();

        return result;
    }

    private int getTotalCount(int[][] arrays) {
        int result = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                result++;
            }
        }
        return result;
    }
}

