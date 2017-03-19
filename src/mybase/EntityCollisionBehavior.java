package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public class EntityCollisionBehavior implements CollisionBehavior {
    private final Entity entity;
    private final Game game;

    public EntityCollisionBehavior(Entity entity, Game game) {
        this.entity = entity;
        this.game = game;
    }

    protected Game getGame() {
        return game;
    }

    protected Entity getEntity() {
        return entity;
    }

    @Override
    public void collideWith(Entity entity) {
    }

    @Override
    public void collideWith(Snake snake) {
    }

    @Override
    public void collideWith(Food food) {
    }

    @Override
    public void collideWith(Wall wall) {
    }
}
