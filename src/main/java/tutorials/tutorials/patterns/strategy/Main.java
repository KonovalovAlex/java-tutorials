package tutorials.tutorials.patterns.strategy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new FullPrice());
        System.out.println(context.getPrice(0.7));
    }
}

interface Strategy {
    double getPrice(double price);
}

class FullPrice implements Strategy {
    @Override
    public double getPrice(double price) {
        return price;
    }
}

class HalfPrice implements Strategy {
    @Override
    public double getPrice(double price) {
        return price * 0.5;
    }
}

class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price) {
        return strategy.getPrice(price);
    }
}
