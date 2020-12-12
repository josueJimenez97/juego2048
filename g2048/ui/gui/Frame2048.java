package g2048.ui.gui;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class Frame2048 extends JFrame{
    private final List<List<Integer>> list;
    private BoardGUI boardGUI;
    private JButton btnUp,btnDown,btnRight,btnLeft,btnQuit;
    private JLabel info;
    public Frame2048(List<List<Integer>> list){
        this.list= list;
    }

    public void initComponents(){
        boardGUI = new BoardGUI(list);
        JPanel instructions = new JPanel();
        JPanel directions = new JPanel();
        directions.setLayout(new GridLayout(2,3,2,2));
        Color x= new Color(146,156,191);
        File file = new File("");
        String root= file.getAbsolutePath();
        btnDown=new JButton("s");
        btnDown.setFocusable(true);
        btnDown.setIcon(new ImageIcon(root+"/src/g2048/ui/gui/img/down.png"));
        btnDown.setBackground(x);
        btnDown.setForeground(x);
        btnUp= new JButton("w");
        btnUp.setBackground(x);
        btnUp.setForeground(x);
        btnUp.setIcon(new ImageIcon("up.png"));
        btnLeft= new JButton("a");
        btnLeft.setForeground(x);
        btnLeft.setBackground(x);
        btnLeft.setIcon(new ImageIcon("left.png"));
        btnRight= new JButton("d");
        btnRight.setBackground(x);
        btnRight.setForeground(x);
        btnRight.setIcon(new ImageIcon("right.png"));
        JButton aux= new JButton();
        aux.setVisible(false);
        JButton aux2= new JButton();
        aux2.setVisible(false);
        directions.add(aux);
        directions.add(btnUp);
        directions.add(aux2);
        directions.add(btnLeft);
        directions.add(btnDown);
        directions.add(btnRight);
        //addKeyListener(this);
        setFocusable(true);
        JPanel panelTitle= new JPanel();
        JLabel title= new JLabel("Welcome to Game 2048");
        btnQuit= new JButton("Quit");
        btnQuit.setForeground(Color.white);
        btnQuit.setBackground(new Color(225,79,87));
        panelTitle.setLayout(new BorderLayout());
        panelTitle.add(title);
        panelTitle.add(btnQuit,BorderLayout.EAST);

        title.setFont(new Font("Helvetica", Font.BOLD, 30));
        info= new JLabel("");
        info.setFont(new Font("Helvetica", Font.ITALIC, 30));
        JLabel labelInstructions= new JLabel();
        labelInstructions.setText("<html><b>INSTRUCTIONS:</b> <br> <br> " +
                "<b>UP:</b> press the <b>w</b> key <br>" +
                "<b>Down:</b> press the <b>s</b> key <br>" +
                "<b>Left:</b> press the <b>a</b> key <br> " +
                "<b>Right:</b> press the <b>d</b> key <br> <br></html>");
        labelInstructions.setFont(new Font("Helvetica", Font.PLAIN, 23));


        instructions.setLayout(new GridLayout(2,1,2,20));
        instructions.add(labelInstructions);
        instructions.add(directions);
        setLayout(new BorderLayout(20,30));
        add(panelTitle,BorderLayout.PAGE_START);
        add(instructions,BorderLayout.LINE_END);
        add(boardGUI,BorderLayout.CENTER);
        add(info,BorderLayout.PAGE_END);
        setSize(680,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void refresh(){
        //msj.setText("The key typed is: ");
        boardGUI.refresh();
    }

    public void addActionPerformed(GuiButtonsListener events){
        btnQuit.addActionListener(events);
        btnUp.getModel().addChangeListener(events);
        btnUp.addActionListener(events);
        btnDown.getModel().addChangeListener(events);
        btnDown.addActionListener(events);
        btnLeft.getModel().addChangeListener(events);
        btnLeft.addActionListener(events);
        btnRight.getModel().addChangeListener(events);
        btnRight.addActionListener(events);
    }

    public void btnPress(char dir){
        Color c= new Color(114,123,153);
        switch (dir) {
            case 'W' -> {
                btnUp.setBackground(c);
                btnUp.setForeground(c);
            }
            case 'S' -> {
                btnDown.setBackground(c);
                btnDown.setForeground(c);
            }
            case 'D' -> {
                btnRight.setBackground(c);
                btnRight.setForeground(c);
            }
            case 'A' -> {
                btnLeft.setBackground(c);
                btnLeft.setForeground(c);
            }
        }
    }

    public void clearDirections(){
        Color c= new Color(146,156,191);
        btnUp.setBackground(c);
        btnUp.setFocusable(false);
        btnUp.setForeground(c);
        btnDown.setBackground(c);
        btnDown.setFocusable(false);
        btnDown.setForeground(c);
        btnRight.setBackground(c);
        btnRight.setFocusable(false);
        btnRight.setForeground(c);
        btnLeft.setBackground(c);
        btnLeft.setFocusable(false);
        btnLeft.setForeground(c);
    }
    public void setMessage(String text){
        info.setText(text);
    }

    public void disabledButtons(){
        btnUp.setEnabled(false);
        btnDown.setEnabled(false);
        btnLeft.setEnabled(false);
        btnRight.setEnabled(false);
    }
}
