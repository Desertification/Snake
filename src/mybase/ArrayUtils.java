package mybase;

/**
 * Created by thoma on 18-Mar-17.
 *
 * Class for storing utility methods related to arrays
 */
public final class ArrayUtils<E> {
    private ArrayUtils() {
    }

    /**
     * check if the array contains the item
     *
     * @param array array to search into
     * @param item  item to search
     * @param <E>   type
     * @return true if found, else false
     */
    public static <E> boolean contains(E[] array, E item) {
        for (E itemFromArray : array) {
            if (itemFromArray.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
