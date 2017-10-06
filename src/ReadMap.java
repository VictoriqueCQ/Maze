import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadMap {
    private int mx, my;
    private int[][] myMap = new int[20][20];
    private BufferedReader br;

    ReadMap() {
        int level_map = 2;
        FileReader r;
        StringBuilder sb = new StringBuilder("");
        int c = 0;//地图上第几个数字
        String s;
        try {
            File f = new File("maps\\" + level_map + ".map");
            r = new FileReader(f);
            br = new BufferedReader(r);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException g) {
            g.printStackTrace();
        }
        byte[] d = sb.toString().getBytes();
        int len = sb.length();
        int[] x = new int[len];
        //ascii码-48后获得实际数字
        for (int i = 0; i < len; i++) {
            x[i] = d[i] - 48;
        }
        //地图布局
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                myMap[i][j] = x[c];
                if (myMap[i][j] == 5) {
                    //获得移动单位坐标
                    mx = j;
                    my = i;
                }
                c++;
            }
        }
    }

    int[][] getMap() {
        return myMap;
    }

    int getManX() {
        return mx;
    }

    int getManY() {
        return my;
    }
}
