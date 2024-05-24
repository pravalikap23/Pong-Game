package src;

import static src.utils.Constants.*;

public class Ball extends Sprite {

    private double vx;
    private double vy;

    public Ball(int x, int y) {
        super(BALL_IMAGE_PATH, x, y, BALL_WIDTH, BALL_HEIGHT);

        // Set vx and vy to initial values
        vx = 4;
        vy = 4;
    }

    @Override
    public void tick() {
        pos.translate((int)vx, (int)vy);
    }

    public void bounceLeft() {
        // update to something
        vx = -(Math.abs(vx) * 1.05);
    }

    public void bounceRight() {
        // update to something
        vx = Math.abs(vx) * 1.05;
    }

    public void bounceDown() {
        // update to something
        vy = 9;
    }

    public void bounceUp() {
        // update to something
        vy = -9;
    }

    public void moveRight() {
        vx = 9;
        vy = 9;
    }

    public void moveLeft() {
        vx = -9;
        vy = -9;
    }
}
