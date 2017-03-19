package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public class Wall extends Entity {
    @Override
    public void collideWith(CollisionBehavior collisionBehavior) {
        collisionBehavior.collideWith(this);
    }
}
