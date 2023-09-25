package tutorials.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagram {

    //    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(str);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            if (map.isEmpty()) {
                List<String> list = new ArrayList<>();
                list.add(str);
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                map.put(new String(charArray), list);
            } else {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sorted = new String(charArray);
                if (map.containsKey(sorted)) {
                    map.get(sorted).add(str);
                } else {
                    ArrayList<String> value = new ArrayList<>();
                    value.add(str);
                    map.put(sorted, value);
                }
            }
        }
        return map.values().stream().toList();
    }

}
