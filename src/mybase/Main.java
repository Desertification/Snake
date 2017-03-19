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
        game.spawnPlayer(EntityType.SNAKE, new Point(5, 5), Direction.RIGHT);
        game.run();
    }
}
