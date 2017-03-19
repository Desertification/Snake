package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public interface CollisionBehavior {
    void collideWith(Entity entity);

    void collideWith(Snake snake);

    void collideWith(Food food);

    void collideWith(Wall wall);
}
