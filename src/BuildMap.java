import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//生成地图，暂时没想好怎么写比较好
class BuildMap {
    BuildMap(int xLength, int yLength, List<Integer> xWallPoint, List<Integer> yWallPoint) throws IOException {
        int[][] map = new int[xLength][yLength];
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                map[i][j] = 1;
            }
        }
        //默认两个list的size相同
        for (int i = 0; i < xWallPoint.size(); i++) {
            map[xWallPoint.get(i)][yWallPoint.get(i)] = 2;
        }
        map[0][1] = 5;
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        int mapNum = 3;
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
//    public static void main(String[] args){
//        List<Integer> xList = new ArrayList<>();
//        List<Integer> yList = new ArrayList<>();
//        int[][] array = {
//                {1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 2, 1, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1},
//                {1, 2, 1, 1, 2, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2, 1, 1, 2, 1, 1},
//                {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1},
//                {1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1},
//                {1, 1, 2, 1, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1},
//                {1, 2, 2, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 1, 1},
//                {1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1},
//                {1, 2, 2, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1},
//                {1, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1},
//                {1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1},
//                {1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1},
//                {1, 2, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 1},
//                {1, 2, 1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1},
//                {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1},
//                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1},
//                {1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1},
//                {1, 1, 1, 2, 2, 2, 2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1},
//                {1, 2, 2, 2, 1, 1, 2, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
//
//        };
//        for(int i = 0;i<20;i++){
//            for(int j = 0;j<20;j++){
//                if(array[i][j] == 2){
//                    xList.add(i);
//                    yList.add(j);
//                }
//            }
//        }
//        try {
//            new BuildMap(20,20,xList,yList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
