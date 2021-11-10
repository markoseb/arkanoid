package Variables;

public class Speed {
    // we need double type for better changing ball direction
    private double speedX;
    private double speedY;

    public Speed(double speedX, double speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
}
