package Elements;

import Dimensions.Point;
import Dimensions.Rectangle;
import Variables.Speed;

import java.awt.*;

public class BonusBox  {


    public boolean  activated = false;
    private Speed speed;
    protected Point startPoint;
    private Rectangle size =  new Rectangle(10, 10);

    public BonusBox( Point startPoint) {
        this.startPoint = startPoint;
        speed = new Speed(0, 2);
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Rectangle getSize() {
        return size;
    }

    public void setSize(Rectangle size) {
        this.size = size;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public void drawMe(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(startPoint.getX(), startPoint.getY(), getSize().getSizeX(), getSize().getSizeY());
        activated = true;
    }

    public int move() {
        setStartPoint( new Point( startPoint.getX(),startPoint.getY() + (int)speed.getSpeedY() ) );

        return 1;
    }

}
