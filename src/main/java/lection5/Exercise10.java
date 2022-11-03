package lection5;
/*
Write a program, which transposes a two dimensional array
 */
// !!!!!!!!!!!!!!!!!!!!!!!! COMPLETE

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise10 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 11}, {4, 5, 6, 12}, {7, 8, 9, 13}};
        Exercise10 ex = new Exercise10();
        ex.transpose(array);
    }

    List<int[][]> transpose(int[][] arr) {
        List<int[][]> result = new ArrayList<>();
        if (!checkRegularArray(arr)) {
            System.out.println("Error data ,this is array is irregular !");
            return result;
        }
        int[][] resultArray = new int[arr[0].length][arr.length];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = getColumn(i, arr);
        }
        print(resultArray);
        result.add(resultArray);
        return result;
    }

    private boolean checkRegularArray(int[][] arr) {
        boolean result = true;
        int lengthRow = arr[0].length;
        for (int[] temp : arr) {
            if (temp.length != lengthRow) {
                result = false;
                break;
            }
        }
        return result;
    }


    private void print(int[][] result) {
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private int[] getColumn(int column, int[][] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i][column];
        }
        return result;
    }
}
