package g2048.gamerules;

import java.util.Arrays;
import java.util.Iterator;

public class IteratorGame implements Iterator {
    private int [][] map;
    private int index,row,col;
    public IteratorGame(int[][] map){
        this.map = map;
        index=0;
    }
    @Override
    public boolean hasNext() {
        return index< map.length;
    }

    @Override
    public Iterable<Integer> next() {
        index++;
        return ()->Arrays.stream(map[index-1]).iterator();
    }
}
