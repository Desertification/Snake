package mybase;

import myLinkedList.Iterator;

/**
 * Created by thoma on 19-Mar-17.
 */
public class SnakeCollisionBehavior extends EntityCollisionBehavior {
    private Snake snake;

    public SnakeCollisionBehavior(Snake snake, Game game) {
        super(snake, game);
        this.snake = snake;
    }

    @Override
    public void collideWith(Snake snake) {
        DeleteEntityAndDropFood(this.snake);
    }

    @Override
    public void collideWith(Food food) {
        Game game = getGame();
        game.deleteEntityLater(food);
        game.spawnEntity(EntityType.FOOD);
        snake.grow();
    }

    @Override
    public void collideWith(Wall wall) {
        DeleteEntityAndDropFood(snake);
    }

    private void DeleteEntityAndDropFood(Snake snake) {
        Game game = getGame();
        Iterator<Location> iterator = snake.getBody().iterator();
        while (iterator.hasNext()) {
            Location location = iterator.next();
            Point point = new Point(location);
            game.spawnEntity(EntityType.FOOD, point, Direction.RIGHT);
        }
        game.deleteEntityLater(snake);
    }
}
