package Calculation;

import Interfaces.CollidableOneDimmennsionInterface;
import Interfaces.CollidableTwoDimmensionInterface;

public class CollisionKeeper {
    public static boolean arkanoidColision(CollidableOneDimmennsionInterface ar, CollidableTwoDimmensionInterface object) {
        return (
                object.getPosition().getY() + object.getSize() > 740 - object.getSpeed().getSpeedY()
                        && ar.getPosition() + ar.getSize() >= object.getPosition().getX()
                        && ar.getPosition() - object.getSize() <= object.getPosition().getX());//because ar.getPosition is left edge position of object not a center!
    }

    // Return the distance from center of the arkanoid
    public static double calculateObjectColission(CollidableOneDimmennsionInterface ar, CollidableTwoDimmensionInterface object) {

        // It tried  calculate  the angle of the tangent line of the circle - not working yet
        //        double tg = xPointColison / (ar.getSize()/2 - xPointColison);
        //        double rad = Math.atan(tg);
        //        double degs = Math.toDegrees(Math.atan(tg));
        //        now I'm using xPointColision paramater

        return (object.getPosition().getX() + object.getSize() / 2 - ar.getPosition() - ar.getSize() / 2);
    }
}