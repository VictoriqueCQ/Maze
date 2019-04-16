import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Maze extends JFrame {
//    private static int x_length;
//    private static int y_length;
    private static BufferedReader br;
    private Maze(int xLength,int yLength) {
        super("迷宫程序");
//        this.x_length = xLength;
//        this.y_length = yLength;
        MainPanel panel;
        setSize(xLength*30+15, yLength*30+40);
        setVisible(true);
        setResizable(false);
        setLocation(300, 20);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container cont = getContentPane();
        cont.setLayout(null);
        cont.setBackground(Color.black);

        panel = new MainPanel(xLength,yLength);
        add(panel);
        panel.RunMaze();
        panel.requestFocus();
        validate();
    }

    public static void main(String[] args) {
//        x_length = 12;
//        y_length = 12;
//        int[][] array1 = {{0, 1}, {3, 1}};
//        int[][] array2 = {{1, 2}, {1, 4}};
//        int[][] array3 = {{0, 6}, {2, 6}};
//        int[][] array4 = {{3, 3}, {3, 6}};
//        int[][] array5 = {{2, 8}, {4, 8}};
//        int[][] array6 = {{1, 8}, {1, 9}};
//        int[][] array7 = {{5, 1}, {5, 2}};
//        int[][] array8 = {{5, 3}, {6, 3}};
//        int[][] array9 = {{7, 0}, {7, 1}};
//        int[][] array10 = {{8, 1}, {8, 2}};
//        int[][] array11 = {{5, 5}, {7, 5}};
//        int[][] array12 = {{8, 4}, {8, 5}};
//        int[][] array13 = {{6, 7}, {7, 7}};
//        int[][] array14 = {{7, 8}, {8, 8}};
//
//        List arrayList = new ArrayList<>();
//        arrayList.add(array1);
//        arrayList.add(array2);
//        arrayList.add(array3);
//        arrayList.add(array4);
//        arrayList.add(array5);
//        arrayList.add(array6);
//        arrayList.add(array7);
//        arrayList.add(array8);
//        arrayList.add(array9);
//        arrayList.add(array10);
//        arrayList.add(array11);
//        arrayList.add(array12);
//        arrayList.add(array13);
//        arrayList.add(array14);


//        java.util.List<Integer> xList = new ArrayList<>();
//        List<Integer> yList = new ArrayList<>();
        int[][] array = {
                {1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 1, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1},
                {1, 2, 1, 1, 2, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2, 1, 1, 2, 1, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1},
                {1, 1, 2, 1, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1},
                {1, 2, 2, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 1, 1},
                {1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1},
                {1, 2, 2, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1},
                {1, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1},
                {1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1},
                {1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1},
                {1, 2, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 1},
                {1, 2, 1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1},
                {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1},
                {1, 1, 1, 2, 2, 2, 2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1},
                {1, 2, 2, 2, 1, 1, 2, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

        };
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 20; j++) {
//                if (array[i][j] == 2) {
//                    xList.add(i);
//                    yList.add(j);
//                }
//            }
//        }
//        try {
//            new BuildMap(x_length, y_length, arrayList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        int xLength=0,yLength=0;
        int mapNum = 1;
        FileReader r;
        StringBuilder sb = new StringBuilder("");
        int c = 0;//地图上第几个数字
        String s;
        try {
            File f = new File("maps\\" + mapNum + ".txt");
            r = new FileReader(f);
            br = new BufferedReader(r);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while ((s = br.readLine()) != null) {
                sb.append(s);
                yLength++;
            }
        } catch (IOException g) {
            g.printStackTrace();
        }
        int len = sb.length();
        xLength = len/yLength;
        new Maze(xLength,yLength);
    }
}




