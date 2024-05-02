package src;

import static src.utils.Constants.*;

public class Ball extends Sprite {

    private int vx;
    private int vy;

    public Ball(int x, int y) {
        super(BALL_IMAGE_PATH, x, y, BALL_WIDTH, BALL_HEIGHT);

        // Set vx and vy to initial values
        vx = 20;
        vy = 15;
    }

    @Override
    public void tick() {
        pos.translate(vx, vy);
    }
}
