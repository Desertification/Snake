package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public interface CollisionBehavior {
    void collideWith(Entity entity);

    void collideWith(Snake snake);
}
