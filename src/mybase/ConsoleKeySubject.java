package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

import java.io.IOException;

/**
 * Created by thoma on 11-Mar-17.
 */
public class ConsoleKeySubject implements Subject<KeyObserver>, Runnable {
    private LinkedList<KeyObserver> observers;
    private ConsoleScanner consoleScanner;
    private int lastKey;

    public ConsoleKeySubject() {
        observers = new LinkedList<>();
        consoleScanner = new ConsoleScanner();
    }

    @Override
    public void registerObserver(KeyObserver observer) {
        observers.append(observer);
    }

    @Override
    public void removeObserver(KeyObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<KeyObserver> iterator = observers.iterator();
        while (iterator.hasNext()) {
            iterator.next().update(lastKey);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                lastKey = consoleScanner.next();
                notifyObservers();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
