package tutorials.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String giveMe(String s){
        System.out.println("giveMe");
        return s;
    }
    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();
        switcher.addElectroListener(lamp);
        switcher.addElectroListener(radio);
        switcher.addElectroListener(Main::giveMe);
        switcher.addElectroListener(new ElectricityConsumer() {
            @Override
            public void electricityOn(String str) {
                System.out.println("fff");
            }
        });
        switcher.switchOn();
    }
}
class Switcher {
    private List<ElectricityConsumer> listeners = new ArrayList<>();
    public void addElectroListener(ElectricityConsumer electricityConsumer) {
        listeners.add(electricityConsumer); }
    public void switchOn() { System.out.println("switchOn");
        for (ElectricityConsumer listener : listeners) {
            listener.electricityOn("switchOn"); } }
}

class Fire implements ElectricityConsumer {
    public Fire(String s) {
    }
    public void electricityOn(String s) { System.out.println("пожар"); }
}
class Lamp implements ElectricityConsumer {
    public void electricityOn(String s) {
        System.out.println("выключатель включен");
    }
    public void lightOn() { System.out.println("лампа зажглась"); }
}
class Radio implements ElectricityConsumer {
    public void electricityOn(String s) { System.out.println("radio is playing"); }
}
interface ElectricityConsumer {
    void electricityOn(String s);
}