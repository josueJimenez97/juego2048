package g2048.gamerules;

import g2048.ui.events.ChangeEvent;
import g2048.ui.events.ChangeEventListener;
import g2048.ui.events.EventType;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.ListIterator;

public class Game2048 implements G2048{
    private Board board;
    public static final int WINNING_NUMBER=32;
    private static ArrayList<EventListener> listeners;
    public Game2048(){
        board= new Board();
        listeners= new ArrayList<>();
    }
    public Game2048(Board board){
        this.board=board;
    }


    public void addEventListener(ChangeEventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void triggerEvent(EventType event) {
        ListIterator li = listeners.listIterator();
        while (li.hasNext()) {
            ChangeEventListener listener = (ChangeEventListener) li.next();
            ChangeEvent changeEvent = new ChangeEvent(this);
            changeEvent.setEvent(event);
            listener.onChange(changeEvent);
            //(listener).onNameChange(readerEvObj);
        }
    }


    @Override
    public void moveUp() {
        board.move(Direction.UP);
        EventType ev= EventType.MOVEMENT;
        ev.setName("W");
        triggerEvent(ev);
        triggerEvent(EventType.BOARD_CHANGE);
    }

    @Override
    public void moveDown() {
        board.move(Direction.DOWN);
        EventType ev= EventType.MOVEMENT;
        ev.setName("S");
        triggerEvent(ev);
        triggerEvent(EventType.BOARD_CHANGE);
    }

    @Override
    public void moveLeft() {
        board.move(Direction.LEFT);
        EventType ev= EventType.MOVEMENT;
        ev.setName("A");
        triggerEvent(ev);
        triggerEvent(EventType.BOARD_CHANGE);
    }

    @Override
    public void moveRight() {
        board.move(Direction.RIGHT);
        EventType ev= EventType.MOVEMENT;
        ev.setName("D");
        triggerEvent(ev);
        triggerEvent(EventType.BOARD_CHANGE);
    }

    @Override
    public boolean winGame() {
        boolean res=  board.containsNumber(WINNING_NUMBER);
        if(res){
            triggerEvent(EventType.WIN);
        }
        return res;
    }

    @Override
    public boolean lostGame() {
        boolean res=  !board.canMove();
        if(res){
            triggerEvent(EventType.LOST);
        }
        return res;
    }

    @Override
    public String toString() {
        return board.toString();
    }

    @Override
    public Iterator<Iterable<Integer>> iterator() {
        return new IteratorGame(board.copyMap());
    }
}
