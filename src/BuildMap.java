import java.io.FileWriter;
import java.io.IOException;

//生成地图，暂时没想好怎么写比较好
class BuildMap {
    BuildMap(int xLength, int yLength, int[] xWallPoint, int[] yWallPoint) throws IOException {
        int[][] map = new int[xLength][yLength];
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                map[i][j] = 2;
            }
        }
        for (int i = 0; i < xWallPoint.length; i++) {
            map[xWallPoint[i]][yWallPoint[i]] = 1;
        }
        map[0][1] = 5;
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        int mapNum = 2;
        String s = "";
        String fileAddress = "maps\\" + mapNum + ".txt";
        FileWriter fw = new FileWriter(fileAddress);
        try {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    s += map[i][j];
                }
                s += "\r\n";
                System.err.print(s);
                fw.write(s);
                s = "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fw.close();
    }
}
