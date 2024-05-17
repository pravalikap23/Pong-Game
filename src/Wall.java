package src;

import java.awt.*;
import java.awt.image.ImageObserver;

import static src.utils.Constants.*;

public class Wall extends Sprite {
    private double x;
    private double y;
    private final Color colour;
    public Wall(int x, int y, Color colour) {
        super(null, 0, 0, WALL_WIDTH, WALL_HEIGHT);
        this.colour = colour;
    }
    @Override
    public void draw(Graphics graphics, ImageObserver observer) {
        graphics.setColor(colour);
        graphics.fillRect(pos.x, pos.y, size.width, size.height);
    }

    @Override
    public void tick() {

    }
}
