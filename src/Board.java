package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static src.utils.Constants.*;
public class Board extends JPanel implements ActionListener, KeyListener {
    private final Ball ball;
    private final List<Sprite> sprites;

    Player leftPaddle;
    Player rightPaddle;

    public Board(){
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.black);

        ball = new Ball(BOARD_WIDTH / 2 - BALL_WIDTH / 2, BOARD_HEIGHT / 2 - BALL_HEIGHT / 2);

        leftPaddle = new Player(10, 200, 75, 3, Color.BLUE);
        rightPaddle = new Player(610, 200, 75, 3, Color.BLUE);

        sprites = new ArrayList<>(List.of(ball, rightPaddle, leftPaddle));

        new Timer(TICK_DELAY, this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Sprite sprite : sprites) {
            sprite.tick();
        }
        repaint();
    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);

        for(Sprite sprite : sprites) {
            sprite.draw(graphics, this);
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            rightPaddle.moveUp();
        } else if (keyCode == KeyEvent.VK_DOWN){
            rightPaddle.moveDown();
        }

        if (keyCode == KeyEvent.VK_W){
            leftPaddle.moveUp();
        } else if (keyCode == KeyEvent.VK_S){
            leftPaddle.moveDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
