package tutorials.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> indexes = findSubstring(s, words);
        indexes.forEach(System.out::println);

    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<String> listConcatinatedWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            for (int j = 0; j < words.length; j++) {
                if (j != i) {
                    word.append(words[j]);
                }
            }
            listConcatinatedWords.add(word.toString());
        }
        for (int i = words.length - 1; i >= 0; i--) {
            StringBuilder word = new StringBuilder(words[i]);
            for (int j = words.length - 1; j >= 0; j--) {
                if (j != i) {
                    word.append(words[j]);
                }
            }
            listConcatinatedWords.add(word.toString());
        }
        return listConcatinatedWords.stream().map(s::indexOf).toList();
    }
}
