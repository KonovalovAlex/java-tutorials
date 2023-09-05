package tutorials.codewars;


import java.util.*;

public class SortWordsByContainsNumber {

    public static void main(String[] args) {

        //"is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
        System.out.println(str("is2 Thi1s T4est 3a"));
        System.out.println(str(""));
    }

    public static String str(String str) {
        //разделить по пробелам, найти цифру, засунуть в мапу, взять из мапы по цифре
        String[] splitted = str.split("\\s+");
        Arrays.sort(splitted, Comparator.comparing(o -> o.replaceAll("[^0-9]", "")));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : splitted) {
//            stringBuilder.append()
        }

        return stringBuilder.toString();
    }
}
