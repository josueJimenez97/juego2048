package g2048.ui.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
public class BoardGUI extends JPanel {
    private int numberRows;
    private List<List<Integer>> values;
    private JLabel[] labels;
    public BoardGUI(List<List<Integer>> values){
        this.values=values;
        this.numberRows=values.size();
        initComponents();
    }
    private void initComponents(){
        setBackground(new Color(222,199,163));
        setLayout(new GridLayout(numberRows,numberRows,3,3));
        labels=new JLabel[numberRows*numberRows];
        refresh();
    }
    public void refresh(){
        //System.out.println(values.size());
        for(int i=0;i<labels.length;i++){
            int value= values.get(i/numberRows).get(i%numberRows);
            String text=value==0? "":value+"";
            if(labels[i]==null){
                JLabel labelAux= new JLabel(text,SwingConstants.CENTER);
                labelAux.setFont(new Font("Helvetica", Font.PLAIN, 70));
                labelAux.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
                labels[i] = labelAux;
                add(labels[i]);
            }else {
                labels[i].setText(text);
            }

        }
    }
}
