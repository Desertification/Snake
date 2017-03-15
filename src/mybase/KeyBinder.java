package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

/**
 * Created by thoma on 15-Mar-17.
 */
public class KeyBinder implements KeyObserver {
    private final int key;
    private LinkedList<Command> commands;

    public KeyBinder(int key) {
        this.key = key;
        commands = new LinkedList<>();
    }

    public synchronized void addCommand(Command command) {
        commands.append(command);
    }

    public synchronized void removeCommand(Command command) {
        commands.remove(command);
    }

    private synchronized void executeCommands() {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            iterator.next().execute();
        }
    }

    @Override
    public void update(Integer update) {
        if (update == key) {
            executeCommands();
        }
    }
}
