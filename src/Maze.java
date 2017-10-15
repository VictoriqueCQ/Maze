import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
        int[] xArray = {1,2,2,2,3};
        int[] yArray = {1,1,2,3,3};
        try {
            new BuildMap(5,5,xArray,yArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Maze();
    }
}




