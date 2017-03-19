package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public class SnakeCollisionBehavior implements CollisionBehavior {
    private Snake snake;
    private Game game;

    public SnakeCollisionBehavior(Snake snake, Game game) {
        this.snake = snake;
        this.game = game;
    }

    @Override
    public void collideWith(Entity entity) {
    }

    @Override
    public void collideWith(Snake snake) {
        // todo spawn food
        game.deleteEntity(snake);
        // todo remove
        game.exit();
    }
}
