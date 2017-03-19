package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public class SnakeBuilder extends EntityBuilder {

    public SnakeBuilder(Game game) {
        super(game);
    }

    @Override
    public Entity build() {
        Game game = getGame();

        Snake snake = new Snake();

        SnakeCollisionBehavior snakeCollisionBehavior = new SnakeCollisionBehavior(snake, game);
        snake.setCollisionBehavior(snakeCollisionBehavior);

        MoveBehavior moveBehavior = new MoveBehavior(snake, game);
        snake.setMoveBehavior(moveBehavior);

        ConsoleSnakeDrawer consoleSnakeDrawer = new ConsoleSnakeDrawer(snake, game.getFrameDrawer());
        snake.setDrawBehavior(consoleSnakeDrawer);

        return snake;
    }

}
