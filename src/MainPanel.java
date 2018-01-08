import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainPanel extends JPanel implements KeyListener {
    private int xLength,yLength;
    private int[][] map;
    private int manX, manY;
    private Image[] myImage;


    MainPanel(int xLength, int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
        setBounds(0, 0, 360, 360);
        setBackground(Color.white);
        addKeyListener(this);
        myImage = new Image[10];
        for (int i = 0; i < 10; i++) {
            myImage[i] = Toolkit.getDefaultToolkit().getImage("pic\\" + i + ".png");
        }
        setVisible(true);
    }

    void RunMaze() {
        ReadMap LevelMap;
        LevelMap = new ReadMap(xLength,yLength);
        map = LevelMap.getMap();
        manX = LevelMap.getManX();
        manY = LevelMap.getManY();
        repaint();
    }

    public void paint(Graphics g) {
        int len = 30;//图片长宽
        for (int i = 0; i < xLength; i++)
            for (int j = 0; j < yLength; j++) {
                g.drawImage(myImage[map[j][i]], i * len, j * len, this);
            }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    private void moveUp() {
        if (manY == 0 || map[manY - 1][manX] == 1) {
            map[manY][manX] = 8;
            repaint();
        } else if (map[manY - 1][manX] == 2) {
            map[manY][manX] = 2;
            map[manY - 1][manX] = 8;
            repaint();
            manY--;
        }
    }

    private void moveDown() {
        if (manY == xLength-1 || map[manY + 1][manX] == 1) {
            map[manY][manX] = 5;
            repaint();
        } else if (map[manY + 1][manX] == 2) {
            map[manY][manX] = 2;
            map[manY + 1][manX] = 5;
            repaint();
            manY++;
        }

    }

    private void moveLeft() {
        if (manX == 0 || map[manY][manX - 1] == 1) {
            map[manY][manX] = 6;
            repaint();
        } else if (map[manY][manX - 1] == 2) {
            map[manY][manX] = 2;
            map[manY][manX - 1] = 6;
            repaint();
            manX--;
        }
    }

    private void moveRight() {
        if (manX == xLength-1 || map[manY][manX + 1] == 1) {
            map[manY][manX] = 7;
            repaint();
        } else if (map[manY][manX + 1] == 2) {

            map[manY][manX] = 2;
            map[manY][manX + 1] = 7;
            repaint();
            manX++;
        }
    }
}
