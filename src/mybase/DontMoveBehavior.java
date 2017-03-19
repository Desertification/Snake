package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public class DontMoveBehavior extends MoveBehavior {
    public DontMoveBehavior(Entity entity, Game game) {
        super(entity, game);
    }

    @Override
    public void move() {
    }
}
