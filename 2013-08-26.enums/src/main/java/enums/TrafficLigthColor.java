package enums;

public class TrafficLigthColor {
    private int code;
    private TrafficLigthColor(int code){
      this.code = code;
    }
    public static final TrafficLigthColor RED = new TrafficLigthColor(0xFF000);
    public static final TrafficLigthColor YELLOW = new TrafficLigthColor(0x00FFFF);
    public static final TrafficLigthColor GREEN = new TrafficLigthColor(0x00FF00);

    public int getCode() {
        return code;
    }
}
