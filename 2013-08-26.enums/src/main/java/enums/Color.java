package enums;

public enum Color implements Runnable,Cloneable {
    RED(0xff0000),GREEN(0x00ff00),YELLOW(0x00ffff);

    int color;
    private Color(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public void run() {
        System.out.println("Dance !!!!!");
    }
}
