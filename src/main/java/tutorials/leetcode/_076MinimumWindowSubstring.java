package tutorials.leetcode;

import java.util.*;

public class _076MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String searchWords = "ABC";
        minWindow2(s, searchWords);
    }

    public static String minWindow(String arrayWords, String searchWords) {
        String[] splitedArrayWords = arrayWords.split("");
        Set<String> searchWordsSet = new HashSet<>();
        LinkedList<Integer> indexes = new LinkedList<>();
        LinkedList<LinkedList<Integer>> countMatchArrayResults = new LinkedList<>();
        countMatchArrayResults.add(new LinkedList<>());
        for (int i = 0; i < splitedArrayWords.length; i++) {
            String word = splitedArrayWords[i];
            if (searchWordsSet.isEmpty()) {
                searchWordsSet = new HashSet<>(List.of(searchWords.split("")));
            }
            if (searchWordsSet.remove(word)) {
                addIndex(i, countMatchArrayResults);
            }
        }
        String resultString = arrayWords.substring(indexes.getFirst(), indexes.getLast());
        //не до конца. Надо лишь выбрать найменьший результат
        return resultString;
    }

    private static void addIndex(int i, LinkedList<LinkedList<Integer>> countMatchArrayResults) {
        if (countMatchArrayResults.getLast().size() < 3) {
            countMatchArrayResults.getLast().add(i);
        } else {
            LinkedList<Integer> indexes = new LinkedList<>();
            indexes.add(i);
            countMatchArrayResults.add(indexes);
        }
    }
    public static String minWindow2(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Считаем количество каждого символа в t
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Количество уникальных символов в t, которые нужно включить в окно
        int required = tMap.size();

        // Хранение текущего окна
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0;
        int formed = 0; // Сколько символов из t выполнены в текущем окне

        // Результат (длина, левый индекс, правый индекс)
        int[] result = {Integer.MAX_VALUE, 0, 0};

        while (right < s.length()) {
            // Добавляем символ из правого указателя в окно
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Проверяем, соответствует ли символ требуемому количеству
            if (tMap.containsKey(c) && windowCounts.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            // Сужаем окно, если оно удовлетворяет условиям
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Обновляем минимальное окно
                if (right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                // Уменьшаем окно
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tMap.containsKey(c) && windowCounts.get(c).intValue() < tMap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            // Расширяем окно
            right++;
        }

        // Если не нашли подходящего окна, возвращаем ""
        return result[0] == Integer.MAX_VALUE ? "" : s.substring(result[1], result[2] + 1);
    }
}

