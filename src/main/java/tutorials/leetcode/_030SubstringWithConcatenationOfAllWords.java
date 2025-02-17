package tutorials.leetcode;

import java.util.*;

public class _030SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> indexes = findSubstring(s, words);
        indexes.forEach(System.out::println);
    }


    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        if (s.length() < totalLength) return result;

        // Создаем карту частот слов из массива words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Проходим по строке s, проверяя подстроки длины totalLength
        for (int i = 0; i <= s.length() - totalLength; i++) {
            String substring = s.substring(i, i + totalLength);
            if (isValidSubstring(substring, wordCount, wordLength)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean isValidSubstring(String substring, Map<String, Integer> wordCount, int wordLength) {
        Map<String, Integer> seen = new HashMap<>();

        // Проходим по подстроке и проверяем слова длины wordLength
        for (int j = 0; j < substring.length(); j += wordLength) {
            String word = substring.substring(j, j + wordLength);
            if (!wordCount.containsKey(word)) {
                return false;
            }
            seen.put(word, seen.getOrDefault(word, 0) + 1);

            // Если слово встречается чаще, чем в исходной карте, это некорректно
            if (seen.get(word) > wordCount.get(word)) {
                return false;
            }
        }
        return true;
    }
}
