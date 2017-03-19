package mybase;

/**
 * Created by thoma on 11-Mar-17.
 */
public interface Collidable {
    CollisionBehavior getCollisionBehavior();

    void collideWith(CollisionBehavior collisionBehavior);
    Hitbox getHitbox();
}
