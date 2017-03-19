package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public abstract class EntityBuilder {
    private Game game;

    public EntityBuilder(Game game) {
        this.game = game;
    }

    protected Game getGame() {
        return game;
    }

    public abstract Entity build();
}
