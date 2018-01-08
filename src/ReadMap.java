import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//读取地图数据
class ReadMap {
//    private int xLength,yLength;
    private int mx, my;
    private int[][] myMap;
    private BufferedReader br;

    ReadMap(int xLength,int yLength) {
//        this.xLength = xLength;
//        this.yLength = yLength;
        int mapNum = 4;
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
        System.out.println("len: "+len);
        //这里有问题，其实并不知道地图是咋样的
        myMap = new int[(int) Math.sqrt(len)][(int) Math.sqrt(len)];
        //地图布局
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
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
