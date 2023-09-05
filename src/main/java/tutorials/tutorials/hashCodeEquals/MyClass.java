package tutorials.hashCodeEquals;

import java.util.Objects;

public class MyClass {
    private Integer age;
    private String name;

    public MyClass(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        System.out.println("equalsing");
        return age == myClass.age && Objects.equals(name, myClass.name);

     //   return false;
    }

    @Override
    public int hashCode() {
        System.out.println("hashcodding");
        return Objects.hash(age, name);
    }
}
