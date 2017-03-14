package mybase;

/**
 * Created by thoma on 14-Mar-17.
 */
public interface Subject<T> {

    void registerObserver(T observer);

    void removeObserver(T observer);

    void notifyObservers();
}
