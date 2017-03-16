package mybase;

/**
 * Created by thoma on 11-Mar-17.
 */
public interface Collidable {
    void collideWith(Collidable other);

    void collideWith(Snake snake);

    Hitbox getHitbox();
}
