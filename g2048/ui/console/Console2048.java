package g2048.ui.console;

import g2048.gamerules.G2048;
import g2048.gamerules.Game2048;
import g2048.ui.events.ChangeEvent;
import g2048.ui.events.EventType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console2048 implements UI2048 {
    private Scanner sc;
    private Game2048 game;
    private List<List<Integer>> values;
    private boolean flag;
    public Console2048(G2048 game) {
        this.game= (Game2048) game;
        this.game.addEventListener(this);
        sc= new Scanner(System.in);
        values= new ArrayList<>();
        updateBoard();
        flag=false;
    }

    @Override
    public void play() {
        showBoard();
        while (!game.winGame()&&!game.lostGame()){
            sc= new Scanner(System.in);
            String input= sc.nextLine();
            if(flag)
                break;
            if(input.length()==1){
                char inputDir =input.toLowerCase().charAt(0);
                if(!moveTo(inputDir)){
                    if(inputDir=='q'){
                        game.triggerEvent(EventType.END_GAME);
                        break;
                    }
                    System.out.println("value entered is not valid");
                }else{
                }
            }else{
                System.out.println("value entered is not valid");
            }
            updateBoard();
            showBoard();
        }
        /*if(game.winGame()){
            //System.out.println("You win");
        }
        if(game.lostGame()){
            //System.out.println("You lost");
        }*/
    }

    @Override
    public void onChange(ChangeEvent changeEvent){
        //System.out.println("escuchando desde la consola");
        EventType ev= changeEvent.getEvent();
        if(ev== EventType.MOVEMENT) {
            System.out.println(ev.getName());
        }else if(ev== EventType.BOARD_CHANGE){
            updateBoard();
            showBoard();
        }else if(ev==EventType.WIN){
            System.out.println("You win");
            flag=true;
        }else if(ev==EventType.LOST){
            System.out.println("You lost");
            flag=true;
        }else if(ev==EventType.END_GAME){
            System.out.println("finish");
            flag=true;
            System.exit(0);
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
        if(!game.winGame()&& !game.lostGame()){
            switch (dir) {
                case 'w' -> {
                    game.moveUp();
                }
                case 's' -> {
                    game.moveDown();
                }
                case 'a' -> {
                    game.moveLeft();
                }
                case 'd' -> {
                    game.moveRight();
                }
                default -> res = false;
            }
        }else{
            res=false;
        }

        return res;
    }

    public void showBoard(){
        String res="";
        for( List<Integer> li : values){
            for (int x : li){
                res+=x+" ";
            }
            res+="\n";
        }
        System.out.println(res);
        System.out.println("w:up\t s:down \t a: left \t d: right");
    }


}
