package experimental;

/**
 * Created by thoma on 19-Mar-17.
 */

class Base {
}

class Sub extends Base {
}

public class equalTest {
    private static Sub sub;

    public static void main(String[] args) {
        sub = new Sub();
        foo(sub);
    }

    public static void foo(Base base) {
        System.out.println("" + (sub == base));
    }
}
