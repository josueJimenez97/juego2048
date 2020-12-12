package g2048.gamerules;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public interface G2048 extends Iterable<Iterable<Integer>>, Game2048Model{
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
    boolean winGame();
    boolean lostGame();
}
