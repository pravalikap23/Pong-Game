package src;

import static src.utils.Constants.*;

public class Ball extends Sprite {

    private int vx;
    private int vy;

    public Ball(int x, int y) {
        super(BALL_IMAGE_PATH, x, y, BALL_WIDTH, BALL_HEIGHT);

        // Set vx and vy to initial values
        vx = 4;
        vy = 4;
    }

    @Override
    public void tick() {
        pos.translate(vx, vy);
    }

    public void bounceLeft() {
        // update to something
        vx = -10;
    }

    public void bounceRight() {
        // update to something
        vx = 10;
    }
}
