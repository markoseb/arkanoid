package Elements;

import Calculation.CollisionKeeper;
import Dimensions.Point;
import Interfaces.CollidableTwoDimmensionInterface;
import Variables.Speed;
//import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Ball implements CollidableTwoDimmensionInterface {
    private Point position;
    private Speed speed;
    private int size = 15;
    private int gamePoints = 0;

    public Ball() {
        position = new Point(30, 600);
        speed = new Speed(-2.5, -2.5);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void drawMe(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval(position.getX(), position.getY(), size, size);

    }

    public int move(Arkanoid ar, Blocks blocks) {
        calculateArkanoidColission(ar);

        gamePoints += calculateBlockColission(blocks);
        if (position.getX() < 3 || position.getX() > 987 - this.getSize()) {
            speed.setSpeedX(speed.getSpeedX() * -1);
        }
        position.setX(position.getX() + (int) speed.getSpeedX());
        if (position.getY() < 0) {
            speed.setSpeedY(speed.getSpeedY() * -1);
        }
        if (position.getY() > 760) {
            return 0;
        }
        position.setY(position.getY() + (int) speed.getSpeedY());
        return 1;
    }


    private boolean isCaughtByBlockCorner(Block block) {
        return true;
    }

    private boolean isCaughtByBlockY(Block block) {
        if (position.getY() + getSize() > block.getStartPoint().getY()
                &&
                position.getY() < block.getStartPoint().getY() + block.getSize().getSizeY()
                &&
                block.getStartPoint().getX() + block.getSize().getSizeX() > position.getX() + getSize() / 4
                &&
                block.getStartPoint().getX() < position.getX() + 3 * getSize() / 4
                &&
                !block.isDeleted()) {
            speed.setSpeedY(speed.getSpeedY() * -1);
            return true;
        }
        return false;
    }


    private boolean isCaughtByBlockX(Block block) {
        if (position.getY() + getSize() / 2 >= block.getStartPoint().getY()
                &&
                position.getY() + getSize() / 2 <= block.getStartPoint().getY() + block.getSize().getSizeY()
                &&
                block.getStartPoint().getX() + block.getSize().getSizeX() >= position.getX()
                &&
                block.getStartPoint().getX() <= position.getX() + getSize()
                &&
                !block.isDeleted()) {
            speed.setSpeedX(speed.getSpeedX() * -1);
            return true;
        }
        return false;
    }

    /**
     * do dodania konta odbicia piłeczki środek góra im blizęj boków tym większy kąt coś pod warunek logarytmiczny
     * <p>
     * Marek
     * Dodałem warunek bazujący na odległości odbicia piłki od środka arkanoida
     * Modyfikuje wartość prędkości speedX według  6.75/(2*ar.getSize());
     * Gdzie 6.75 to zakres prędkości X [-3,375,3,375] - dla tego zakresu arkanoid prawidłowo odbija piłkę.
     */

    private double calculateXSpeed(Arkanoid ar) {

        double colissionDist = CollisionKeeper.calculateObjectColission(ar, this);
        // 6.75 - seedX range for constant v value
        double CoefficientDev = 6.75 / (2.5 * ar.getSize());
        // ball closer right side edges -> bigger SpeedX value, and smaller SpeedY.
        return colissionDist * CoefficientDev + speed.getSpeedX();
    }


    private void calculateArkanoidColission(Arkanoid ar) {
        if (CollisionKeeper.arkanoidColision(ar, this)) {
            //-coding style spaces after coma
            double v = Math.pow(speed.getSpeedX(), 2) + Math.pow(speed.getSpeedY(), 2);// speed vector length square
            double newSpeedX = calculateXSpeed(ar);

            if (newSpeedX > 3.375) // max vale
                newSpeedX = 3.375;

            else if (newSpeedX < -3.375)
                newSpeedX = -3.375;
            //-coding style spaces after coma
            double b = Math.sqrt(v - Math.pow(newSpeedX, 2)) / speed.getSpeedY(); // keep the initial length of the vector
            speed.setSpeedY(-speed.getSpeedY() * b);
            speed.setSpeedX(newSpeedX);
        }
    }

    private int calculateBlockColission(Blocks blocks) {
        /**
         * dodatkowo potrzebne jest rozróżnienie czy odbicie jest od boku czy spodu bloku w przypadku odbicia do boku
         * zmienia się prędkość x nie y
         */
        for (int i = 0; i < blocks.listOfBlocks.length; i++) {
            for (int j = 0; j < blocks.listOfBlocks[i].length; j++) {
                if (isCaughtByBlockX(blocks.listOfBlocks[i][j]) || isCaughtByBlockY(blocks.listOfBlocks[i][j])) {
                    blocks.listOfBlocks[i][j].setHitsToDestroy(blocks.listOfBlocks[i][j].getHitsToDestroy() - 1);
                    if (blocks.listOfBlocks[i][j].getHitsToDestroy() == 0) {
                        blocks.listOfBlocks[i][j].setDeleted(true);
                        return blocks.listOfBlocks[i][j].getPoints();
                    }
                    return 0;
                }
            }
        }
        return 0;
    }

    public int getGamePoints() {
        return gamePoints;
    }

    public int addPoints(int points) {
        gamePoints += points;
        return gamePoints;
    }

    public void clearGamePoints() {
        gamePoints = 0;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "position=" + position.toString() +
                ", speed=" + speed.toString() +
                ", size=" + size +
                ", gamePoints=" + gamePoints +
                '}';
    }
}
