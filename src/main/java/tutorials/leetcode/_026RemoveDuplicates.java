package tutorials.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _026RemoveDuplicates {
    public static void main(String[] args) {

        _026RemoveDuplicates a026RemoveDuplicates = new _026RemoveDuplicates();
        List<Integer> numbers = Arrays.asList(1,3,2,4,5,1,4,6);
        a026RemoveDuplicates.removeDuplicates(numbers).forEach(System.out::println);
    }
    public List<Integer> removeDuplicates(List<Integer> input){
        return input.stream().distinct().collect(Collectors.toList());
    }
}
