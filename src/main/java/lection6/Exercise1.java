package lection6;

/*
1) Write a method, which removes the duplicates contained in a passed array.
a) Also write a method, which removes the duplicates contained in a passed ArrayList.
b) Removing duplicates in ArrayList can be implemented differently from removing
duplicates in an array, esp. as far as performance is concerned. – What does this
statement mean? If appropriate play around with different implementations! –
Where are pros and cons
 */

// !!!!!!!!!!!!!!!!!!!!!!!! COMPLETE

import java.util.*;

public class Exercise1 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 45, 3, 2};
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(3);
        list1.add(1);
        list1.add(3);

        List<String> list2 = new Vector();
        list2.add("qwerty");
        list2.add("qwerty");
        list2.add("qwerty");
        list2.add("qwerty2");
        metodA(arr);
        metodA_2(arr);
        metodA_3(arr);
        metodA_4(arr);
        System.out.println("###########################");
        metodB(list1);
        metodB_generic(list2);
        metodB_generic(list1);
    }

    static int[] metodA(int[] array) {
        Set<Integer> unicElements = new TreeSet<>();
        for (int temp : array) {
            unicElements.add(temp);
        }
        int[] result = new int[unicElements.size()];
        List<Integer> tempList = new ArrayList<>(unicElements);
        for (int i = 0; i < result.length; i++) {
            result[i] = tempList.get(i);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    static int[] metodA_3(int[] array) {
        int[] result = Arrays.stream(array).distinct().toArray();
        System.out.println(Arrays.toString(result));
        return result;
    }

    static int[] metodA_4(int[] array) {
        List<Integer> tempResult = new ArrayList<>();
        Arrays.sort(array);
        int currentValue = array[0];
        tempResult.add(currentValue);
        for (int i = 1; i < array.length; i++) {
            if (array[i] != currentValue) {
                currentValue = array[i];
                tempResult.add(currentValue);
            }
        }
        System.out.println(tempResult);
        int[] result = new int[tempResult.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tempResult.get(i);
        }
        return result;
    }

    //
    static int[] metodA_2(int[] array) {
        String[] tempArray = new String[array.length];
        int currentPosition = 0;
        for (int temp : array) {
            if (!isFind(temp, tempArray)) {
                tempArray[currentPosition] = String.valueOf(temp);
                currentPosition++;
            }
        }
        int[] result = new int[currentPosition];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.valueOf(tempArray[i]);
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    private static boolean isFind(int temp, String[] tempArray) {
        boolean result = false;
        for (String str : tempArray) {
            if (str != null && str.equals(String.valueOf(temp))) {
                result = true;
                break;
            }
        }
        return result;
    }

    static void metodB(List<Integer> list) {
        Set<Integer> tempResult = new TreeSet<>(list);
        list.clear();
        list.addAll(tempResult);
        System.out.println(list);
    }

    static <T extends Comparable> void metodB_generic(List<T> list1) {
        Set<T> tempResult = new TreeSet<>(list1);
        list1.clear();
        list1.addAll(tempResult);
        System.out.println(list1);
    }
}
