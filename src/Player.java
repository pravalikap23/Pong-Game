package src;

import java.awt.*;
import java.util.Set;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;


import static src.utils.Constants.*;

public class Player extends Sprite{
    private double dx;
    private double dy;
    private final Color colour;

    public Player(int x, int y, int height, int speed, Color colour){
        super(null, x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
        this.colour = colour;
    }

    @Override
    public void draw(Graphics graphics, ImageObserver observer) {
        graphics.setColor(colour);
        graphics.fillRect(pos.x, pos.y, size.width, size.height);
    }

    @Override
    public void tick() {
        pos.translate((int)dx, (int)dy);
    }

    public void moveUp() {
        pos.translate(0, -PADDLE_SPEED);
    }

    public void moveDown() {
        pos.translate(0, PADDLE_SPEED);
    }

    private void normalizeDeltas() {
        if (dx != 0 && dy != 0) {
            dx /= Math.sqrt(2);
            dy /= Math.sqrt(2);
        }
    }

    public void handleCollision(Sprite other){
        if(other.getClass().equals(Board.class)) {
            Point previousPos = new Point(pos.x - (int)dx, pos.y - (int)dy);

            if(dx > 0 && previousPos.x + size.width <= other.getTopLeft().x) {
                pos.x = other.getTopLeft().x - size.width;
            }
            else if(dx < 0 && previousPos.x >= other.getBottomRight().x) {
                pos.x = other.getBottomRight().x;
            }

            if(dy > 0 && previousPos.y + size.height <= other.getTopLeft().y) {
                pos.y = other.getTopLeft().y - size.height;
            }
            else if(dy < 0 && previousPos.y >= other.getBottomRight().y) {
                pos.y = other.getBottomRight().y;
            }
        }
    }
}
