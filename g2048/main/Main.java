package g2048.main;

import g2048.gamerules.G2048;
import g2048.gamerules.Game2048;
import g2048.ui.console.Console2048;
import g2048.ui.gui.GUI2048;

public class Main {
    public static void main(String[] args) {
        G2048 game = new Game2048();
        Console2048 console = new Console2048(game);
        GUI2048 gui= new GUI2048(game);

        gui.play();
        console.play();
    }
}
