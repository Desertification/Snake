package experimental;

/**
 * Created by thoma on 19-Mar-17.
 * <p>
 * testing ground for fixing the collision code
 * <p>
 * Method overloading type polymorphism is determined at the compile time in Java.
 * This causes issues with the current collision code.
 * Visitor pattern promises to solve it.
 * <p>
 * https://en.wikipedia.org/wiki/Visitor_pattern#Java_example
 * refactored to fit collision code
 */


interface Collidable {
    /**
     * @return the collision behavior of the Collidable object
     */
    CollisionBehavior getCollisionBehavior();

    /**
     * @param collisionBehavior the collision behavior of the target, It knows what type of entity it works for
     */
    void collideWith(CollisionBehavior collisionBehavior);
}

/**
 * contains the possible collision types
 */
interface CollisionBehavior {
    void collideWith(Entity entity);

    void collideWith(Body body);

    void collideWith(Engine engine);
}

abstract class Entity implements Collidable {
    private CollisionBehavior collisionBehavior = new EntityCollisionBehavior();

    abstract public void collideWith(CollisionBehavior collisionBehavior);

    @Override
    public CollisionBehavior getCollisionBehavior() {
        return collisionBehavior;
    }

    public void setCollisionBehavior(CollisionBehavior collisionBehavior) {
        this.collisionBehavior = collisionBehavior;
    }
}

class Body extends Entity {
    public void collideWith(final CollisionBehavior collisionBehavior) {
        collisionBehavior.collideWith(this);
    }
}

class Engine extends Entity {
    public void collideWith(final CollisionBehavior visitor) {
        visitor.collideWith(this);
    }
}

class EntityCollisionBehavior implements CollisionBehavior {
    public void collideWith(final Body body) {
        System.out.println("entity with body");
    }

    public void collideWith(final Entity entity) {
        System.out.println("entity with entity");
    }

    public void collideWith(final Engine engine) {
        System.out.println("entity with engine");
    }
}

class BodyCollisionBehavior implements CollisionBehavior {
    public void collideWith(final Body body) {
        System.out.println("body with body");
    }

    public void collideWith(final Entity entity) {
        System.out.println("body with entity");
    }

    public void collideWith(final Engine engine) {
        System.out.println("body with engine");
    }
}

class EngineCollisionBehavior implements CollisionBehavior {
    public void collideWith(final Body body) {
        System.out.println("engine with body");
    }

    public void collideWith(final Entity entity) {
        System.out.println("engine with entity");
    }

    public void collideWith(final Engine engine) {
        System.out.println("engine with engine");
    }
}

public class VisitorDemo {
    public static void main(final String[] args) {
        Entity engine = new Engine();
        engine.setCollisionBehavior(new EngineCollisionBehavior());
        Entity body = new Body();
        body.setCollisionBehavior(new BodyCollisionBehavior());

        body.collideWith(engine.getCollisionBehavior());

        engine.collideWith(body.getCollisionBehavior());
    }
}
