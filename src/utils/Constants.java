package src.utils;

import static java.awt.Color.black;

public final class Constants {
    private Constants(){
        // prevents instantiation
    }

    // Board
    public static final int BOARD_WIDTH = 640;
    public static final int BOARD_HEIGHT = 480;
    public static final int TICK_DELAY = 25;

    // Ball
    public static final String BALL_IMAGE_PATH = "resources/ball.png";
    public static final int BALL_WIDTH = 40;
    public static final int BALL_HEIGHT = 40;

    // Player
    public static final int PLAYER_WIDTH = 15;
    public static final int PLAYER_HEIGHT = 75;
    public static final int PADDLE_SPEED = 25;

    // Wall
    public static final int WALL_HEIGHT = 50;
}
