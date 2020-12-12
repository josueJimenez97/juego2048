package g2048.ui.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GuiKeyListener implements KeyListener {
    private final GUI2048 gui;
    public GuiKeyListener(GUI2048 gui){
        this.gui= gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        String s= c+"";
        gui.eventKey(s.toLowerCase().charAt(0));
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }




}
