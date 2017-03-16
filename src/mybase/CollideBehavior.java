package mybase;

/**
 * Created by thoma on 16-Mar-17.
 */
public abstract class CollideBehavior implements Collidable {
    protected Game game;
    private Collidable collidable;

    protected CollideBehavior(Collidable collidable, Game game) {
        this.collidable = collidable;
        this.game = game;
    }

    @Override
    public abstract void collideWith(Collidable other);

    @Override
    public abstract void collideWith(Snake snake);

    @Override
    public Hitbox getHitbox() {
        return collidable.getHitbox();
    }
}
