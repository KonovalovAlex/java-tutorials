package tutorials.generic;

import java.io.Serializable;

public class Gener {
    public static void main(String[] args) {


        Cell<Job> cell = new Cell<>();
        cell.setT(new Job());
        cell.doJob();
    }
}
class Job implements Serializable{

    public void doit() {
        System.out.println("do it");
    }
}
class ChildJob extends Job{

}
class Cell<T extends Job & Serializable>{
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    public void doJob(){
        t.doit();

    }
}
