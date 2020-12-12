package g2048.ui.gui;

import g2048.gamerules.G2048;
import g2048.gamerules.Game2048;
import g2048.ui.events.ChangeEvent;
import g2048.ui.events.EventType;

import java.util.ArrayList;
import java.util.List;

public class GUI2048 implements UI2048 {
    private final Frame2048 frame;
    private final Game2048 game;
    private final List<List<Integer>> values;
    private final GuiButtonsListener e;
    private final GuiKeyListener keyListener;
    public GUI2048(G2048 game){
        this.game= (Game2048) game;
        this.game.addEventListener(this);
        values= new ArrayList<>();
        updateBoard();
        frame= new Frame2048(values);
        e= new GuiButtonsListener(this);
        keyListener= new GuiKeyListener(this);

    }


    @Override
    public void play() {
        frame.initComponents();
        frame.addActionPerformed(e);
        frame.addKeyListener(keyListener);
    }

    public void eventKey(char key){
        //System.out.println("capturando la tecla: "+key);
        if(moveTo(key)){
            updateBoard();
            frame.refresh();
            game.winGame();
            game.lostGame();
        }else if(key=='q'){
            game.triggerEvent(EventType.END_GAME);
        }

    }
    public void updateBoard(){
        values.clear();
        for(Iterable<Integer> iterable : game) {
            List<Integer> listAux= new ArrayList<>();
            for( int x: iterable){
                listAux.add(x);
            }
            values.add(listAux);
        }
    }
    public boolean moveTo(char dir){
        boolean res=true;
            switch (dir) {
                case 'w' -> {
                    game.moveUp();
                    //frame.btnPress('W');
                }
                case 's' -> {
                    game.moveDown();
                    //frame.btnPress('S');
                }
                case 'a' -> {
                    game.moveLeft();
                    //frame.btnPress('A');
                }
                case 'd' -> {
                    game.moveRight();
                    //frame.btnPress('D');
                }
                default -> res = false;
            }



        return res;
    }

    public void winGame(){
        frame.setMessage("You Win");
        frame.setFocusable(false);
        frame.disabledButtons();
    }

    public void lostGame(){
        frame.setMessage("You Lost");

    }

    @Override
    public void onChange(ChangeEvent changeEvent) {
        EventType ev= changeEvent.getEvent();
        if(ev== EventType.MOVEMENT) {
            frame.clearDirections();
            frame.btnPress(ev.getName().charAt(0));
        }else if(ev== EventType.BOARD_CHANGE){
            updateBoard();
            frame.refresh();
        }else if(ev==EventType.WIN){
            //System.out.println("win de la gui");
            winGame();
        }else if(ev==EventType.LOST){
            //System.out.println("lost de la gui");
            lostGame();
        }else if(ev==EventType.END_GAME){
            frame.dispose();
        }
    }

    public void clearDirectionsBtn(){
        frame.clearDirections();
    }

}
