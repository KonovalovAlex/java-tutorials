package tutorials.strings;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s1 = new String("S1");
        String s2 = new String("S1");
        System.out.println(s1.intern()==s2.intern() );
        System.out.println(s1.equals(s2));
    }
}
