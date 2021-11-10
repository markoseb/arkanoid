package Calculation;

import Dimensions.Point;
import Elements.Arkanoid;
import Elements.Ball;
import Variables.Speed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollisionKeeperTest {
    Arkanoid ar;
    Ball ball;

    @BeforeEach
    void setUp() {
        ar = new Arkanoid(3, 66);
        ball = new Ball();
        ball.setSpeed(new Speed(-2, 2));
    }
    @Test
    @DisplayName("No collision")
    void testCollisions() {
        assertFalse(CollisionKeeper.arkanoidColision(ar, ball), "No collision");
    }
    @Test
    @DisplayName("No collision")
    void testNoCollisions() {
        ball.setPosition(new Point(400, 500));
        assertFalse(CollisionKeeper.arkanoidColision(ar, ball), "No collision");
    }
    @Test
    @DisplayName("collision")
    void testCollisionsTrue() {
        ball.setPosition(new Point(60,
                728));
        assertTrue(CollisionKeeper.arkanoidColision(ar, ball), "collision");
    }
    @Test
    @DisplayName("collision")
    void testCollisionsRightSide() {
        ball.setPosition(new Point(69,
                728));
        assertTrue(CollisionKeeper.arkanoidColision(ar, ball), "collision");
    }
    @Test
    @DisplayName("collision")
    void testCollisionsLeftSide() {
        ball.setPosition(new Point(3,
                728));
        assertTrue(CollisionKeeper.arkanoidColision(ar, ball), "collision");
    }

}