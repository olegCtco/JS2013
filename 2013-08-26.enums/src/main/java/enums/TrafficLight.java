package enums;

public class TrafficLight {

    static public TrafficLight trafficLight;

    void setColor(int color) {
        if (color < 1 || color > 3) {
            throw new TrafficLightException("FIGNJA VAS COLOR:" + color);
        }
    }
    void setColor(TrafficLigthColor color) {
        System.out.println("Color code:"+color.getCode());
    }

    Color color;
    synchronized void setColor(Color color){
        System.out.println("Try set by:"+Thread.currentThread().getName());
        this.color = color;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println("Color code:"+this.color.getColor());
    }
    void setColor(Runnable color){
        color.run();
    }
}
