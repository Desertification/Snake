package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

/**
 * Created by thoma on 15-Mar-17.
 */
public class KeyBinder implements KeyObserver {
    private final Integer[] keys;
    private LinkedList<Command> commands;

    public KeyBinder(Integer... key) {
        this.keys = key;
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
        if (ArrayUtils.contains(keys, update)) {
            executeCommands();
        }
    }
}
