package Elements;

import Interfaces.CollidableOneDimmennsionInterface;

import java.awt.*;

public class Arkanoid implements CollidableOneDimmennsionInterface {
    private int position;
    /**
     * size must be 11 * X
     */
    private int size = 66;
    private int moveSpeed = 20;

    public Arkanoid(int position, int size) {
        this.position = position;
        this.size = size;
    }

    Arkanoid(int position) {
        this.position = position;
    }

    public void drawMe(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillRect(
                position,
                740,
                size,
                4
        );
    }

    public int getPosition() {
        return position;
    }

    public Arkanoid setPosition(int position) {
        this.position = position;
        return this;
    }

    public int getSize() {
        return size;
    }

    public Arkanoid setSize(int size) {
        this.size = size;
        return this;
    }

    public void moveRight() {
        if (getPosition() + getSize() + getMoveSpeed() > 1000 - 6) {
            setPosition(1000 - 16 - getSize());
        } else {
            setPosition(getPosition() + getMoveSpeed());
        }
    }

    public void moveLeft() {
        if (getPosition() - getMoveSpeed() < 3) {
            setPosition(3);
        } else {
            position = getPosition() - getMoveSpeed();
        }
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public Arkanoid setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
        return this;
    }

}
