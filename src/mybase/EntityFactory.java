package mybase;

/**
 * Created by thoma on 18-Mar-17.
 */
public class EntityFactory {
    private Game game;

    public EntityFactory(Game game) {
        this.game = game;
    }

    public Entity create(EntityType entityType, Point location, Direction direction) {
        Entity entity;
        switch (entityType) {
            case FOOD:
                entity = new Snake(); // todo
                break;
            case SNAKE:
                entity = new SnakeBuilder(game).build();
                break;
            case WALL:
                entity = new Snake(); // todo
                break;
            default:
                throw new RuntimeException("Unknown entity type");
        }
        entity.setLocation(location);
        entity.setDirection(direction);
        return entity;
    }
}
