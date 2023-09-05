package tutorials.codewars;

public class HowMuchChar {

    public static void main(String[] args) {
        int res = myFunction("h", "helhtloh");
        int res2 = myFunction2("h", "helhtloh");
        System.out.println(res);
        System.out.println(res2);
    }

    private static int myFunction(String c, String w) {
        int result = 1;
        int indexChar = w.indexOf(c);
        if (indexChar >= 0) {
            for (int i = 0; i < w.length(); i++) {
                String substringLeft;
                if (indexChar == 0) {
                    substringLeft = "";
                } else {
                    substringLeft = w.substring(0, indexChar);
                }
                String substringRight = w.substring(indexChar + 1);
                w = substringLeft.concat(substringRight);
                result = result + myFunction(c, w);
                return result;
            }
        }
        return result - 1;
    }

    private static int myFunction2(String c, String w) {

        char someChar = c.charAt(0);
        int count = 0;

        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == someChar) {
                count++;
            }
        }
        return count;
    }

    private static int myFunction3(String c, String w) {
        long count = w.chars().filter(ch -> ch == c.charAt(0)).count();
        return (int) count;
    }
}
