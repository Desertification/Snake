package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public class WallBuilder extends EntityBuilder {
    public WallBuilder(Game game) {
        super(game);
    }

    @Override
    public Entity build() {
        Game game = getGame();

        Wall wall = new Wall();

        WallCollisionBehavior wallCollisionBehavior = new WallCollisionBehavior(wall, game);
        wall.setCollisionBehavior(wallCollisionBehavior);

        DontMoveBehavior dontMoveBehavior = new DontMoveBehavior(wall, game);
        wall.setMoveBehavior(dontMoveBehavior);

        ConsoleWallDrawer consoleWallDrawer = new ConsoleWallDrawer(wall, game.getFrameDrawer());
        wall.setDrawBehavior(consoleWallDrawer);

        return wall;
    }
}
