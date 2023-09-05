package tutorials.codewars.algTasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        List<Integer> numbers = Arrays.asList(1,3,2,4,5,1,4,6);
        removeDuplicates.removeDuplicates(numbers).forEach(System.out::println);
    }
    public List<Integer> removeDuplicates(List<Integer> input){
        return input.stream().distinct().collect(Collectors.toList());
    }
}
