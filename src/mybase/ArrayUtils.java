package mybase;

/**
 * Created by thoma on 18-Mar-17.
 */
public final class ArrayUtils<E> {
    private ArrayUtils() {
    }

    public static <E> boolean contains(E[] array, E item) {
        for (E itemFromArray : array) {
            if (itemFromArray.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
