package mybase;

/**
 * Created by thoma on 11-Mar-17.
 */
public interface Collidable {
    /**
     * @return the specific collision behavior of the collidable
     */
    CollisionBehavior getCollisionBehavior();

    /**
     * @param collisionBehavior knows what to do when colliding with other types
     */
    void collideWith(CollisionBehavior collisionBehavior);

    /**
     * @return the hitbox object of the collidable
     */
    Hitbox getHitbox();

    /**
     * @param hitbox the soon to be hitbox of the collidable
     */
    void setHitbox(Hitbox hitbox);
}
