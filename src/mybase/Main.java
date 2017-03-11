package mybase;


public class Main {
    public static void main(String[] args) {
        Dimension dimension = new Dimension(30, 15);
        ConsoleFrameDrawer consoleFrameDrawer = new ConsoleFrameDrawer(System.out, dimension);
        Snake snake = new Snake();
        Game game = new Game();
        game.setBounds(dimension);

        SnakeBehavior snakeBehavior = new SnakeBehavior(game);
        snakeBehavior.setSnake(snake);
        snake.setUpdateBehavior(snakeBehavior);

        ConsoleSnakeDrawer consoleSnakeDrawer = new ConsoleSnakeDrawer(consoleFrameDrawer);
        consoleSnakeDrawer.setSnake(snake);
        ConsoleSnakeDrawer debugConsoleSnakeDrawer = new DebugConsoleSnakeDrawer(consoleFrameDrawer);
        debugConsoleSnakeDrawer.setSnake(snake);

        snake.setDrawBehavior(consoleSnakeDrawer);

        snake.grow();
        snake.grow();
        snake.grow();
        snake.grow();

        while (true) {
            snake.draw();
            snake.update();
            snake.setDrawBehavior(debugConsoleSnakeDrawer);
            consoleFrameDrawer.drawFrame();
            sleep();
            snake.draw();
            snake.update();
            snake.setDrawBehavior(consoleSnakeDrawer);
            consoleFrameDrawer.drawFrame();
            sleep();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
