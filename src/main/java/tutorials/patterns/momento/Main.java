package tutorials.patterns.momento;


public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("one");

        CateTaker cateTaker = new CateTaker();
        cateTaker.setMomento(originator.createMomento());

        originator.setState("two");
        originator.getDataFromMomento(cateTaker.getMomento());
        System.out.println(originator.getState());
    }
}


class CateTaker {
    Momento momento;

    public Momento getMomento() {
        return momento;
    }

    public void setMomento(Momento momento) {
        this.momento = momento;
    }
}


class Originator {
    private String state;

    public String getState() {
        return state;
    }

    Momento createMomento() {
        return new Momento(state);
    }

    void getDataFromMomento(Momento momento) {
        this.state = momento.getState();
    }

    public void setState(String state) {
        this.state = state;
    }
}


class Momento {
    String state;

    public Momento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
