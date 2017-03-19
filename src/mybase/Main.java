package mybase;

//todo bug, you can put the snake in reverse if fast enough
//todo BUILDERS, the game can use some builders
//todo food for the poor snake
//todo collide code
//todo hide linked list implementation in snake
//todo MORE tests

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Dimension bounds = game.getBounds();
        game.spawnPlayer(EntityType.SNAKE, new Point(5, bounds.height / 2), Direction.RIGHT);
        game.spawnEntity(EntityType.FOOD);
        for (int x = 0; x < bounds.width; x++) {
            game.spawnEntity(EntityType.WALL, new Point(x, 0));
            game.spawnEntity(EntityType.WALL, new Point(x, bounds.height - 1));
        }
        for (int y = 1; y < bounds.height - 1; y++) {
            if (y == bounds.height / 2) {
                continue;
            }
            game.spawnEntity(EntityType.WALL, new Point(0, y));
            game.spawnEntity(EntityType.WALL, new Point(bounds.width - 1, y));
        }
        game.run();
    }
}
