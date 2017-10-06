import javax.swing.*;
import java.awt.*;

public class Maze extends JFrame{
    private Maze(){
        super("迷宫程序");
        MainPanel panel;
        setSize(600, 630);
        setVisible(true);
        setResizable(false);
        setLocation(300, 20);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container cont = getContentPane();
        cont.setLayout(null);
        cont.setBackground(Color.black);

        panel = new MainPanel();
        add(panel);
        panel.RunMaze();
        panel.requestFocus();
        validate();
    }
    public static void main(String[] args) {
        new Maze();
    }
}




