package g2048.ui.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiButtonsListener implements ActionListener, ChangeListener {
    private final GUI2048 gui;
    public GuiButtonsListener(GUI2048 gui){
        this.gui= gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Quit" -> gui.eventKey('q');
            case "w" -> gui.eventKey('w');
            case "s" -> gui.eventKey('s');
            case "a" -> gui.eventKey('a');
            case "d" -> gui.eventKey('d');
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        ButtonModel model = (ButtonModel) e.getSource();
        /*if(model.isRollover()){
            System.out.println("is rollover");
        }*/
        if(!model.isPressed()){
            //System.out.println("esta presionado");
            //gui.clearDirectionsBtn();
        }
      /*  if(model.isArmed()){
            System.out.println("is armed");
        }
        if(model.isSelected()){
            System.out.println("is select");
        }*/
    }
}
