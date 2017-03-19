package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public class FoodBuilder extends EntityBuilder {
    public FoodBuilder(Game game) {
        super(game);
    }

    @Override
    public Entity build() {
        Game game = getGame();

        Food food = new Food();

        FoodCollisionBehavior foodCollisionBehavior = new FoodCollisionBehavior(food, game);
        food.setCollisionBehavior(foodCollisionBehavior);

        DontMoveBehavior dontMoveBehavior = new DontMoveBehavior(food, game);
        food.setMoveBehavior(dontMoveBehavior);

        ConsoleFoodDrawer consoleFoodDrawer = new ConsoleFoodDrawer(food, game.getFrameDrawer());
        food.setDrawBehavior(consoleFoodDrawer);

        return food;
    }
}
