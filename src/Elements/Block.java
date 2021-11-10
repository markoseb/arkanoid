package Elements;

import Dimensions.Point;
import Dimensions.Rectangle;

import java.awt.*;

public class Block {
    /**
     * klasa do przetrzymywania rozmiaru bloku na podstawie wyliczenia rozmiaru
     */
    private Rectangle size;
    /**
     * punkt w którym zaczyna się rysowanie
     */
    protected Point startPoint;
    public boolean deleted = false;
    private int points = 1;
    private boolean bonus = getRandomBoolean(20);
    private Color color;
    private int hitsToDestroy = 1;

    public BonusBox bonusBox = null;
    private Point bonusStartPoint = new Point(0, 0);

    public Block(Rectangle size, Point startPoint) {
        this.size = size;
        this.startPoint = startPoint;
        addBonus();
    }

    public Block(Rectangle size, Point startPoint, boolean deleted, int hitsToDestroy, Color color) {
        this.size = size;
        this.startPoint = startPoint;
        this.deleted = deleted;
        this.hitsToDestroy = hitsToDestroy;
        this.color = color;
        addBonus();
    }

    public Block(Rectangle size, Point startPoint, boolean deleted, Color color) {
        this.size = size;
        this.startPoint = startPoint;
        this.deleted = deleted;
        this.color = color;
        addBonus();
    }

    public Block(Rectangle size, Point startPoint, boolean deleted) {
        this.size = size;
        this.startPoint = startPoint;
        this.deleted = deleted;
        addBonus();
    }
    public Block(Rectangle size, Point startPoint, int hitsToDestroy, int points, Color color) {
        this.size = size;
        this.startPoint = startPoint;
        this.hitsToDestroy = hitsToDestroy;
        this.color = color;
        this.points = points;
        addBonus();
    }

    public Block(Rectangle size, Point startPoint, Color color) {
        this.size = size;
        this.startPoint = startPoint;
        this.color = color;
        addBonus();
    }

    public Rectangle getSize() {
        return size;
    }

    public void setSize(Rectangle size) {
        this.size = size;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void drawMe(Graphics g) {
        g.setColor(this.color);
        g.fillRect(startPoint.getX(), startPoint.getY(), size.getSizeX(), size.getSizeY());
    }

    public void drawBonusBox(Graphics g) {
        if (this.bonusBox != null) {
            this.bonusBox.drawMe(g);
            this.bonusBox.move();
        }
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setBonusStartPoint() {
        this.bonusStartPoint.setX(this.startPoint.getX() + this.size.getSizeX() / 2);
        this.bonusStartPoint.setY(this.startPoint.getY() + this.size.getSizeY() / 2);
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getHitsToDestroy() {
        return hitsToDestroy;
    }

    public void setHitsToDestroy(int hitsToDestroy) {
        this.hitsToDestroy = hitsToDestroy;
    }

    static boolean getRandomBoolean(int probability) {
        double randomValue = Math.random() * 100;  //0.0 - 99.9
        return randomValue <= probability;
    }

    public void addBonus() {
        if (this.bonus == true && !this.deleted) {
            setBonusStartPoint();
            this.bonusBox = new BonusBox(bonusStartPoint);
        }
    }
}
