package mybase;

/**
 * Created by thoma on 16-Mar-17.
 */
public class SnakeCollideBehavior extends CollideBehavior {
    private Snake snake;

    public SnakeCollideBehavior(Snake snake, Game game) {
        super(snake, game);
        this.snake = snake;
    }

    @Override
    public void collideWith(Collidable other) {

    }

    @Override
    public void collideWith(Snake snake) {
        game.exit();
    }
}
