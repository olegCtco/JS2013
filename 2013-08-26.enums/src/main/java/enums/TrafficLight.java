package enums;

public class TrafficLight {
    void setColor(int color) {
        if (color < 1 || color > 3) {
            throw new TrafficLightException("FIGNJA VAS COLOR:" + color);
        }
    }
    void setColor(TrafficLigthColor color) {
        System.out.println("Color code:"+color.getCode());
    }
    void setColor(Color color){
        System.out.println("Color code:"+color.getColor());
    }
    void setColor(Runnable color){
        color.run();
    }
}
