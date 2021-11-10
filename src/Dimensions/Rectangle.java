package Dimensions;

public class Rectangle {
    private int sizeX;
    private int sizeY;

    public Rectangle(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sizeX=" + sizeX +
                ", sizeY=" + sizeY +
                '}';
    }
}
