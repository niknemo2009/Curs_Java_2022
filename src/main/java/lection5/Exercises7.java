package lection5;
/*
7. Write a predicate methods that checks, whether the passed string is an anagram. An
anagram is a text made by exchanging the letters of another text. For example,
"parliament" is an anagram of "partial men".
 */
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!! NO COMPLETE
import java.util.Arrays;

public class Exercises7 {

    public static void main(String[] args) {
        System.out.println(isAnagramm("  a      rt","tra"));
        System.out.println(isAnagramm(" aj     rt","tra"));
    }

   static boolean isAnagramm(String str1, String str2) {
 boolean result=true;
 String[] arr1=str1.trim().split("[ ]+");
 String[] arr2=str2.trim().split("[ ]+");
 StringBuilder sb1=new StringBuilder();
        for (String temp:arr1) {
            sb1.append(temp);
        }
        StringBuilder sb2=new StringBuilder();
        for (String temp:arr2) {
            sb2.append(temp);
        }
       char[] chars1=sb1.toString().toLowerCase().toCharArray();
       char[] chars2=sb2.toString().toLowerCase().toCharArray();
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
}