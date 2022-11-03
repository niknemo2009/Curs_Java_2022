package lection5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//5) Write a method, which shuffles elements in an array. Mind to write a unit test
//!!!!!!!!!!!!!!!!!!!!!!!!!!! COMPLETE
public class Exercise5 {
    public static void main(String[] args) {
        Exercise5 ex = new Exercise5();
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        ex.shuffle(array1);
        System.out.println(Arrays.toString(array1));
    }

    void shuffle(int[] array) {
        List<Integer> tempList = new ArrayList<>();
        for (int temp : array) {
            tempList.add(temp);
        }
        Collections.shuffle(tempList);
        int[] result = tempList.stream().mapToInt(x -> x.intValue()).toArray();
        for (int i = 0; i < result.length; i++) {
            array[i] = result[i];
        }
        System.out.println(Arrays.toString(array));
    }

}
