package mybase;

/**
 * Created by thoma on 18-Mar-17.
 */
public class EntityCreator {
    private Game game;

    public EntityCreator(Game game) {
        this.game = game;
    }

    public Entity create(EntityType entityType) {
        Entity entity;
        switch (entityType) {
            case FOOD:
                entity = new Entity(); // todo proper creation
                break;
            case SNAKE:
                entity = new Entity(); // todo
                break;
            case WALL:
                entity = new Entity(); // todo
                break;
            default:
                throw new RuntimeException("Unknown entity type");
        }
        return entity;
    }
}
