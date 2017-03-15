package mybase;

//todo bug, you can put the snake in reverse if fast enough
//todo BUILDERS, the game can use some builders
//todo food for the poor snake
//todo collide code
//todo hide linked list implementation in snake
//todo MORE tests

public class Main {
    public static void main(String[] args) {
        Dimension dimension = new Dimension(30, 15);
        ConsoleFrameDrawer consoleFrameDrawer = new ConsoleFrameDrawer(System.out, dimension);
        Snake snake = new Snake();
        Game game = new Game();
        game.setBounds(dimension);

        ConsoleKeySubject consoleKeySubject = new ConsoleKeySubject();
        Thread keySubjectThread = new Thread(consoleKeySubject, "consoleKeySubject");
        keySubjectThread.setDaemon(true);

        KeyBinder upBind = new KeyBinder(KeyBindings.up);
        upBind.addCommand(() -> snake.setDirection(Direction.UP));
        consoleKeySubject.registerObserver(upBind);

        KeyBinder downBind = new KeyBinder(KeyBindings.down);
        downBind.addCommand(() -> snake.setDirection(Direction.DOWN));
        consoleKeySubject.registerObserver(downBind);

        KeyBinder leftBind = new KeyBinder(KeyBindings.left);
        leftBind.addCommand(() -> snake.setDirection(Direction.LEFT));
        consoleKeySubject.registerObserver(leftBind);

        KeyBinder rightBind = new KeyBinder(KeyBindings.right);
        rightBind.addCommand(() -> snake.setDirection(Direction.RIGHT));
        consoleKeySubject.registerObserver(rightBind);

        KeyBinder escBind = new KeyBinder(KeyBindings.esc);
        escBind.addCommand(() -> System.exit(0));
        consoleKeySubject.registerObserver(escBind);

        keySubjectThread.start();

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
            consoleFrameDrawer.clearFrame();
            sleep();
            snake.draw();
            snake.update();
            snake.setDrawBehavior(consoleSnakeDrawer);
            consoleFrameDrawer.drawFrame();
            consoleFrameDrawer.clearFrame();
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
