package tutorials.tastSortMassives;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Task {
    public static void main(String[] args) {
        String strings = "abc bca abcd addb accb ab ba cbafd cabfd ";
        String[] array = strings.split("\\s+");
        Map<String, List<String>> stringListMap = Arrays.stream(array)
                .sorted(Comparator.comparing(String::length).reversed().thenComparing(String::compareTo))
                .collect(groupingBy(p->p.substring(0,1)));
        System.out.println(stringListMap);
    }
}