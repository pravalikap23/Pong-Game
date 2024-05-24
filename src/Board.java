package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
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

    Wall topWall;
    Wall bottomWall;

    private int rally;
    private int highscore;
    private boolean running = true;

    public Board(){
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.black);

        ball = new Ball(BOARD_WIDTH / 2 - BALL_WIDTH / 2, BOARD_HEIGHT / 2 - BALL_HEIGHT / 2);

        leftPaddle = new Player(10, 200, 75, 3, Color.BLUE);
        rightPaddle = new Player(610, 200, 75, 3, Color.BLUE);

        topWall = new Wall(0, 0, Color.BLACK);
        bottomWall = new Wall(0, BOARD_HEIGHT - WALL_HEIGHT, Color.BLACK);

        sprites = new ArrayList<>(List.of(ball, rightPaddle, leftPaddle, topWall, bottomWall));

        highscore = Rally.getHighrally();

        new Timer(TICK_DELAY, this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            for (Sprite sprite : sprites) {
                sprite.tick();
            }

            if (ball.isColliding(leftPaddle)) {
                ball.bounceRight();
                rally += 1;
            } else if (ball.isColliding(rightPaddle)) {
                rally += 1;
                ball.bounceLeft();
            } else if (ball.isColliding(topWall)) {
                ball.bounceDown();
            } else if (ball.isColliding(bottomWall)) {
                ball.bounceUp();
            }
            // else if colliding with walls - reverse vy

            if (ball.getPos().x - BALL_WIDTH > BOARD_WIDTH) {
                resetBall();
                leftPaddle.setScore(leftPaddle.getScore() + 1);
            } else if (ball.getPos().x < 0) {
                resetBall();
                rightPaddle.setScore(rightPaddle.getScore() + 1);
            }
        }
        repaint();
    }

    private void resetBall() {
        ball.getPos().x = BOARD_WIDTH / 2;
        ball.getPos().y = BOARD_HEIGHT / 2;

        if (rally > highscore) {
            Rally.writeNewHighRally(rally);
            highscore = rally;
        }
        rally = 0;
        if (leftPaddle.getScore() > rightPaddle.getScore()) {
            ball.moveLeft();
        } else {
            ball.moveRight();
        }
    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);

        for(Sprite sprite : sprites) {
            sprite.draw(graphics, this);
        }

        graphics.setColor(Color.WHITE);

        float[] dashingPattern2 = {5f, 4f};
        Stroke stroke = new BasicStroke(4f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 1.0f, dashingPattern2, 0.0f);

        graphics.setFont(new Font(graphics.getFont().getFontName(), Font.PLAIN, 23));
        graphics.drawString("Pong Game", 265, 27);
        graphics.setFont(new Font(graphics.getFont().getFontName(), Font.PLAIN, 17));
        graphics.drawString("Rally: "+ rally, 245, 55);
        graphics.drawString("Highest Rally: "+ highscore, 245, 75);

        graphics.setFont(new Font(graphics.getFont().getFontName(), Font.PLAIN, 15));
        graphics.drawString("Player 1: " + leftPaddle.getScore(), 90, 35);

        graphics.setFont(new Font(graphics.getFont().getFontName(), Font.PLAIN, 15));
        graphics.drawString("Player 2: " + rightPaddle.getScore(), BOARD_WIDTH - 150, 35);

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setStroke(stroke);
        g2d.draw(new Line2D.Double((double) BOARD_WIDTH / 2, 0, (double) BOARD_WIDTH / 2, BOARD_HEIGHT));

        if (leftPaddle.getScore() == 11) {
            graphics.setColor(Color.WHITE);
            graphics.drawRect((BOARD_WIDTH / 2) - 100, 100, 100, 100);
            graphics.setColor(Color.WHITE);
            graphics.drawString("Player 1 won", (BOARD_WIDTH / 2) - 90, 150);
            running = false;
        } else if (rightPaddle.getScore() == 11) {
            graphics.setColor(Color.WHITE);
            graphics.drawRect((BOARD_WIDTH / 2) - 100, 100, 100, 100);
            graphics.setColor(Color.WHITE);
            graphics.drawString("Player 2 won", (BOARD_WIDTH / 2) - 90, 150);
            running = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();

        if (running) {
            if (keyCode == KeyEvent.VK_UP) {
                if (!rightPaddle.isColliding(topWall)) {
                    rightPaddle.moveUp();
                }
            } else if (keyCode == KeyEvent.VK_DOWN) {
                if (!rightPaddle.isColliding(bottomWall)) {
                    rightPaddle.moveDown();
                }
            }

            if (keyCode == KeyEvent.VK_W) {
                if (!leftPaddle.isColliding(topWall)) {
                    leftPaddle.moveUp();
                }
            } else if (keyCode == KeyEvent.VK_S) {
                if (!leftPaddle.isColliding(bottomWall)) {
                    leftPaddle.moveDown();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
