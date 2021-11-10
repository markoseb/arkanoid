package Elements;

import Dimensions.Point;
import Dimensions.Rectangle;

import java.awt.*;

public class BlockFactory {
    public static Block create(char type, Point point, Rectangle rectangle) {
        return switch (type) {
            case 'm' -> new Block(rectangle, point, Color.WHITE);
            case 'e' -> new Block(rectangle, point, true);
            case 'r' -> new Block(rectangle, point, 3, 6, Color.RED);
            default -> new Block(rectangle, point, Color.WHITE);
        };
    }
}
