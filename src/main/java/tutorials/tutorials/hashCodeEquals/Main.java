package tutorials.hashCodeEquals;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass(1, "vasya");
        MyClass myClass2 = new MyClass(1, "vasya");
        MyClass myClass3 = new MyClass(1, "vasya");

        System.out.println(myClass.hashCode());
        System.out.println(myClass2.hashCode());
        System.out.println(myClass.equals(myClass2));
        System.out.println(myClass==myClass2);

        Set<MyClass> objects = new HashSet<>();
        objects.add(myClass);
        System.out.println("added");
        objects.add(myClass2);

        System.out.println(objects.size());
    }
}


