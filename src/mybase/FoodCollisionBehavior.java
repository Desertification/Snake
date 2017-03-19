package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public class FoodCollisionBehavior extends EntityCollisionBehavior {
    public FoodCollisionBehavior(Entity entity, Game game) {
        super(entity, game);
    }

    @Override
    public void collideWith(Snake snake) {
        // todo not sure about this
        // handled in snakeCollisionBehavior
    }

    @Override
    public void collideWith(Food food) {
        getGame().deleteEntityLater(getEntity());
    }

    @Override
    public void collideWith(Wall wall) {
        // bad location respawn
        getGame().deleteEntityLater(getEntity());
        getGame().spawnEntity(EntityType.FOOD);
    }
}
