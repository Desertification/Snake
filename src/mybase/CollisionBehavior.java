package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public interface CollisionBehavior {
    /**
     * @param entity to collide with
     */
    void collideWith(Entity entity);

    /**
     * @param snake to collide with
     */
    void collideWith(Snake snake);

    /**
     * @param food to collide with
     */
    void collideWith(Food food);

    /**
     * @param wall to collide with
     */
    void collideWith(Wall wall);
}
