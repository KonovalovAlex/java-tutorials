package tutorials.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _068TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth).toString());
    }

    //не закончено

    public static List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();
        int lengthWords = 0;
        int minSpaces = 1;
        for (int i = 0; i < words.length; i++, minSpaces++) {
            String wordLength = words[i];
            lengthWords += wordLength.length();
            if (lengthWords + minSpaces >= maxWidth) {
                lengthWords -= wordLength.length();
                result.add(getStringCombinedWords(i, lengthWords, words, maxWidth));
                lengthWords = 0;
            }
        }
        return result;
    }

    private static String getStringCombinedWords(int countOfWords, int lengthWords, String[] allWords, int maxWidth) {
        StringBuilder result = new StringBuilder();
        int maxSpaces = maxWidth - lengthWords;
        int i1 = maxSpaces / (countOfWords - 1);
        int i2 = maxSpaces % (countOfWords - 1);
        for (int i = 0; i < countOfWords; i++) {
            if (i == 0) {
                result.append(allWords[i]).append(i1).append(i2).append("\n");
            } else if (i == countOfWords - 1) {
                result.append(allWords[i]).append("\n");
            } else {
                result.append(allWords[i]).append(i1);
            }
        }
        return result.toString();
    }
}
