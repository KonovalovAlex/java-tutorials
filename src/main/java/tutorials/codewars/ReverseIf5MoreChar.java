package tutorials.codewars;

public class ReverseIf5MoreChar {

    public static void main(String[] args) {
        System.out.println("Hey fellow warriors");
    }
    //можно сделать через стрим

    //приходит стринга если в ней слова больше 5 символов ревёрсит это слово и возвращает кол таких слов
    public static String spinWords(String sentence) {
        //TODO: Code stuff here
        StringBuilder finalString = new StringBuilder();
        StringBuilder reverse;
        String[] splited = sentence.split("\\s+");
        int length = splited.length;
        for (int i = 0; i < length; i++) {
            if (splited[i].length() >= 5) {
                reverse = new StringBuilder(splited[i]).reverse();
                finalString.append(reverse).append(" ");
            } else {
                finalString.append(splited[i]).append(" ");
            }

        }
        finalString.setLength(finalString.length()-1);
        return finalString.toString();
    }
}
