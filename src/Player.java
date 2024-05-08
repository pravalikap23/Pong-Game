package src;

import java.awt.*;

import static src.utils.Constants.*;

public class Player extends Sprite{
    private final int x;
    private final int y;
    private final int height;
    private final int speed;
    private final Color colour;
    private Player rightPaddle, leftPaddle;

    public Player(int x, int y, int height, int speed, Color colour){
        super(PLAYER_IMAGE_PATH, 0, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
        this.x = x;
        this.y = y;
        this.height = height;
        this.speed = speed;
        this.colour = colour;
    }

    public void paint(Graphics graphics){
        graphics.setColor(colour);
        int PADDLE_WIDTH = 15;
        graphics.fillRect(x, y, PADDLE_WIDTH, height);
    }

    @Override
    public void tick() {

    }

    public int getSpeed() {
        return speed;
    }
}
