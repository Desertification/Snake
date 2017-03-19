package mybase;

/**
 * Created by thoma on 11-Mar-17.
 * interface for all the observer objects
 * Observer Pattern
 */
public interface Observer<T> {
    /**
     * notify the observers of new data
     *
     * @param update the new data
     */
    void update(T update);
}
