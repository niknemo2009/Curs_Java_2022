package lection5;
/*
Write a method, which accepts a String[] words, a String keyword and the int
minLength and returns another String[]. This method should retrieve all Strings in
words, which contain the keyword having a length >= minLength.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise8 {

    public static void main(String[] args) {
        final int minLength=5;
        String substr="abc";
      Predicate<String>  condition1=x->x.length()>3;
      Predicate<String>  condition2=x->x.indexOf(substr)!=-1&&x.length()>=minLength;
        System.out.println(Arrays.toString(getStrings(condition1,"qw","qw")));
        System.out.println(Arrays.toString(getStrings(condition2,"qwabc","abcq")));
        System.out.println(Arrays.toString(getStrings("abc",5,"abcabc","abcq")));
    }

   static String[]   getStrings( Predicate<String> condition,String ... strs){
        String[] result=new String[(int)Arrays.stream(strs).filter(x->condition.test(x)).count()];
        return Arrays.stream(strs).filter(x->condition.test(x)).collect(Collectors.toList()).toArray(result);
    }

    static String[]   getStrings( String keyword,int minLength,String ... strs){
      List<String> result=new ArrayList<>();
        for (String temp:strs ) {
            if(temp.matches("[A-Za-z0-9]*("+keyword+")+")==true&&temp.length()>=minLength){
                result.add(temp);
            }
        }
        return result.toArray(new String[0]);
    }
}
