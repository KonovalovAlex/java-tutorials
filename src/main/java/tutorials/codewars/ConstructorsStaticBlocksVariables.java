package tutorials.codewars;

public class ConstructorsStaticBlocksVariables {
    public static void main(String[] args) {
        A a = new B();
        a.print();
    }
    static class A {
        A() {
            print();
            //вызов принт класса а
        }

        void print() {
            System.out.println("A");
        }
    }
    static class B extends A {
        int i = Math.round(3.5f);
        void print() {
            System.out.println(i);
        }
    }
}
