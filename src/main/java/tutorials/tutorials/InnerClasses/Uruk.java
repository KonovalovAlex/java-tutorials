package tutorials.InnerClasses;

public class Uruk extends Jook{
    int i;
    String b;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
    //не может содержать статик методы, независимо наследуется от др классов
    class Innert extends Jook{
        int d;
        public void testt (
        ){

        }
    }
    //может содержать статик методы
    static class UrukChild {
        int g;
        String f;

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public String getF() {
            return f;
        }

        public void setF(String f) {
            this.f = f;
        }
    }
}
