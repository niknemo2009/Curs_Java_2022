package lection5;
/*
7. Write a predicate methods that checks, whether the passed string is an anagram. An
anagram is a text made by exchanging the letters of another text. For example,
"parliament" is an anagram of "partial men".
 */
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!! COMPLETE
import java.util.Arrays;

public class Exercises7 {

    public static void main(String[] args) {
        System.out.println(isAnagramm("  a      rt","tra"));
        System.out.println(isAnagramm(" aj     rt","tra"));
    }

   static boolean isAnagramm(String str1, String str2) {
 boolean result=true;
       char[] chars1=killSpace(str1).toCharArray();
       char[] chars2=killSpace(str2).toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if(chars1.length!=chars2.length){
            return false;
        }
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i]!=chars2[i]){
                result=false;
                break;
            }
        }
 return  result;
    }

    public static String killSpace(String str) {
        String[] arr1= str.trim().split("[ ]+");
        StringBuilder sb1=new StringBuilder();
        for (String temp:arr1) {
            sb1.append(temp);
        }
        return sb1.toString().toLowerCase();
    }
}