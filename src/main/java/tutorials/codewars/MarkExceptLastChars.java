package tutorials.codewars;

public class MarkExceptLastChars {
    public static void main(String[] args) {
        System.out.println(maskify("4556364607935616"));
    }

    public static String maskify(String str) {
        String[] s = str.split("");
        StringBuilder stringBuilder = new StringBuilder();
        int length = s.length;

        for (int i = 0; i <= s.length-1; i++) {
            if (i < length - 4) {
                stringBuilder.append(s[i].replace(s[i], "#"));
            } else {
                stringBuilder.append(s[i]);
            }
        }
        return stringBuilder.toString();
        //  throw new UnsupportedOperationException("Unimplemented");
    }
}
