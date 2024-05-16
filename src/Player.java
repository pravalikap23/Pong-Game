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

    public void handleActiveKeys(Set<Integer> activeKeyCodes) {
        normalizeDeltas();
    }

    private void normalizeDeltas() {
        if (dx != 0 && dy != 0) {
            dx /= Math.sqrt(2);
            dy /= Math.sqrt(2);
        }
    }
}
