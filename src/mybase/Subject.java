package mybase;

/**
 * Created by thoma on 14-Mar-17.
 * interface for all the objects that are subjects and can be observed by observers
 * Observer Pattern
 */
public interface Subject<T> {

    /**
     * add observer to list of objects to be notified of changes
     *
     * @param observer object to notify of change
     */
    void registerObserver(T observer);

    /**
     * removes the observer, no longer notify it of changes
     * @param observer object to notify of change
     */
    void removeObserver(T observer);

    /**
     * notify all the registered observers
     */
    void notifyObservers();
}
