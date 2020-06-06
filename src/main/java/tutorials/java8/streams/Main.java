package tutorials.java8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[][]data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
//Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);
//Stream<String>, GOOD!
        Stream<String> stringStream = temp.flatMap(Arrays::stream);
        Stream<String> stream = stringStream.filter("a"::equals);
        stream.forEach(System.out::println);
        /** Stream<String> stream = Arrays.stream(data)
         .flatMap(x -> Arrays.stream(x))
         .filter(x -> "a".equals(x.toString()));**/
}}
