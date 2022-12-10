package main.java.helpers;

public class signalStrength implements Signal {
    private int x;
    public signalStrength(int x) {
        this.x = x;
    }
    @Override
    public int getx() {
        return x;
    }
    public void setx(int x) {
        this.x = x;
    }

    @Override
    public int getSignalStrength(int cycle) {
        return x*cycle;
    }
}
