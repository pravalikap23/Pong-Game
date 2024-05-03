package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

import static src.utils.Constants.*;

public class Player extends Sprite{
    private double dx;
    private double dy;

    public Player() {
        super(PLAYER_IMAGE_PATH,0, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    @Override
    public void tick() {
        pos.translate((int)dx, (int)dy);

    }

    public void handleActiveKeys(Set<Integer> activeKeyCodes){
        dx = 0;
        dy = 0;

    }
}
