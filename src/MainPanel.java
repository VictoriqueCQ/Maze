import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainPanel extends JPanel implements KeyListener {
    private int[][] map, mapTmp;
    private int manX, manY;
    private Image[] myImage;


    MainPanel() {
        setBounds(15, 50, 600, 600);
        setBackground(Color.white);
        addKeyListener(this);
        myImage = new Image[10];
        for (int i = 0; i < 10; i++) {
            myImage[i] = Toolkit.getDefaultToolkit().getImage("pic\\" + i + ".gif");
        }
        setVisible(true);
    }

    void RunMaze() {
        ReadMap LevelMap;
        ReadMap LevelMapTmp;
        LevelMap = new ReadMap();
        LevelMapTmp = new ReadMap();
        map = LevelMap.getMap();
        manX = LevelMap.getManX();
        manY = LevelMap.getManY();
        mapTmp = LevelMapTmp.getMap();
        repaint();
    }

    public void paint(Graphics g) {
        int len = 30;
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++) {
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
        if (map[manY - 1][manX] == 2 || map[manY - 1][manX] == 4) {
            if (mapTmp[manY][manX] == 4 || mapTmp[manY][manX] == 9) {
                map[manY][manX] = 4;
            } else {
                map[manY][manX] = 2;
            }
            map[manY - 1][manX] = 8;
            repaint();
            manY--;
        } else if (map[manY - 1][manX] == 3 || map[manY - 1][manX] == 9) {
            if (map[manY - 2][manX] == 4) {
                if (mapTmp[manY][manX] == 4 || mapTmp[manY][manX] == 9) {
                    map[manY][manX] = 4;
                } else {
                    map[manY][manX] = 2;
                }
                map[manY - 1][manX] = 8;
                map[manY - 2][manX] = 9;
                repaint();
                manY--;
            } else if (map[manY - 2][manX] == 2) {
                if (mapTmp[manY][manX] == 4 || mapTmp[manY][manX] == 9) {
                    map[manY][manX] = 4;
                } else {
                    map[manY][manX] = 2;
                }
                map[manY - 1][manX] = 8;
                map[manY - 2][manX] = 3;
                repaint();
                manY--;
            } else {
                map[manY][manX] = 8;
                repaint();
            }
        }
        if (map[manY - 1][manX] == 1) {
            map[manY][manX] = 8;
            repaint();
        }
    }

    private void moveDown() {
        if (map[manY + 1][manX] == 2 || map[manY + 1][manX] == 4) {
            if (mapTmp[manY][manX] == 4 || mapTmp[manY][manX] == 9) {
                map[manY][manX] = 4;
            } else {
                map[manY][manX] = 2;
            }
            map[manY + 1][manX] = 5;
            repaint();
            manY++;
        } else if (map[manY + 1][manX] == 3 || map[manY + 1][manX] == 9) {
            if (map[manY + 2][manX] == 4) {
                if (mapTmp[manY][manX] == 4 || mapTmp[manY][manX] == 9) {
                    map[manY][manX] = 4;
                } else {
                    map[manY][manX] = 2;
                }
                map[manY + 1][manX] = 5;
                map[manY + 2][manX] = 9;
                repaint();
                manY++;
            } else if (map[manY + 2][manX] == 2) {
                if (mapTmp[manY][manX] == 4 || mapTmp[manY][manX] == 9) {
                    map[manY][manX] = 4;
                } else {
                    map[manY][manX] = 2;
                }
                map[manY + 1][manX] = 5;
                map[manY + 2][manX] = 3;
                repaint();
                manY++;
            } else {
                map[manY][manX] = 5;
                repaint();
            }
        } else if (map[manY + 1][manX] == 1) {
            map[manY][manX] = 5;
            repaint();
        }
    }

    private void moveLeft() {
        if (map[manY][manX - 1] == 2 || map[manY][manX - 1] == 4) {
            if (mapTmp[manY][manX] == 4 || mapTmp[manY][manX] == 9)
                map[manY][manX] = 4;
            else map[manY][manX] = 2;
            map[manY][manX - 1] = 6;
            repaint();
            manX--;
        } else if (map[manY][manX - 1] == 3 || map[manY][manX - 1] == 9) {
            if (map[manY][manX - 2] == 4) {
                if (mapTmp[manY][manX] == 4 || mapTmp[manY][manX] == 9) {
                    map[manY][manX] = 4;
                } else {
                    map[manY][manX] = 2;
                }
                map[manY][manX - 1] = 6;
                map[manY][manX - 2] = 9;
                repaint();
                manX--;

            } else if (map[manY][manX - 2] == 2) {
                if (mapTmp[manY][manX] == 4 || mapTmp[manY][manX] == 9) {
                    map[manY][manX] = 4;
                } else {
                    map[manY][manX] = 2;
                }
                map[manY][manX - 1] = 6;
                map[manY][manX - 2] = 3;
                repaint();
                manX--;

            } else {
                map[manY][manX] = 6;
                repaint();
            }
        } else if (map[manY][manX - 1] == 1) {
            map[manY][manX] = 6;
            repaint();
        }
    }

    private void moveRight() {
        if (map[manY][manX + 1] == 2 || map[manY][manX + 1] == 4) {
            if (mapTmp[manY][manX] == 4 || mapTmp[manY][manX] == 9)
                map[manY][manX] = 4;
            else map[manY][manX] = 2;
            map[manY][manX + 1] = 7;
            repaint();
            manX++;
        } else if (map[manY][manX + 1] == 3 || map[manY][manX + 1] == 9) {
            if (map[manY][manX + 2] == 4) {
                if (mapTmp[manY][manX] == 4) {
                    map[manY][manX] = 4;
                } else {
                    map[manY][manX] = 2;
                }
                map[manY][manX + 1] = 7;
                map[manY][manX + 2] = 9;
                repaint();
                manX++;

            } else if (map[manY][manX + 2] == 2) {
                if (mapTmp[manY][manX] == 4) {
                    map[manY][manX] = 4;
                } else {
                    map[manY][manX] = 2;
                }
                map[manY][manX + 1] = 7;
                map[manY][manX + 2] = 3;
                repaint();
                manX++;

            } else {
                map[manY][manX] = 7;
                repaint();
            }
        } else if (map[manY][manX + 1] == 1) {
            map[manY][manX] = 7;
            repaint();
        }
    }
}
