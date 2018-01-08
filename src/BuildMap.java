import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BuildMap {
//    private int xLength;
//    private int yLength;

    BuildMap(int xLength, int yLength, List arrayList) throws IOException {
//        this.xLength = xLength;
//        this.yLength = yLength;
        int[][] map = new int[xLength][yLength];
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                map[i][j] = 2;
            }
        }
        System.out.println(arrayList.size());
        for(int i = 0;i<arrayList.size();i++){
            int[][] newArray = (int[][])arrayList.get(i);
            System.out.println("{{"+newArray[0][0]+","+newArray[0][1]+"},{"+newArray[1][0]+","+newArray[1][1]+"}}");
            if(newArray[0][1]==newArray[1][1]){//如果y相同，此线段垂直
                if(newArray[0][0]>=newArray[1][0]){
                    for(int j = newArray[1][0]+1;j<=newArray[0][0]+1;j++){
                        map[j][newArray[0][1]+1] = 1;
                    }
                }else if(newArray[0][0]<newArray[1][0]){
                    for(int j = newArray[0][0]+1;j<=newArray[1][0]+1;j++){
                        map[j][newArray[0][1]+1] = 1;
                    }
                }
            }else{//线段水平
                if(newArray[0][1]>=newArray[1][1]){
                    for(int j = newArray[1][1]+1;j<=newArray[0][1]+1;j++){
                        map[newArray[0][0]+1][j] = 1;
                    }
                }else if(newArray[0][1]<newArray[1][1]){
                    for(int j = newArray[0][1]+1;j<=newArray[1][1]+1;j++){
                        map[newArray[0][0]+1][j] = 1;
                    }
                }
            }
        }
        for(int i = 0;i<xLength;i++){
            map[0][i] = 1;
            map[yLength-1][i] = 1;
            map[i][0] = 1;
            map[i][xLength-1] = 1;
        }
        //默认两个list的size相同
//        for (int i = 0; i < xWallPoint.size(); i++) {
//            map[xWallPoint.get(i)][yWallPoint.get(i)] = 2;
//        }
        map[0][1] = 5;
//        for (int i = 0; i < xLength; i++) {
//            for (int j = 0; j < yLength; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
        int mapNum = 4;
        String s = "";
        String fileAddress = "maps\\" + mapNum + ".txt";
        FileWriter fw = new FileWriter(fileAddress);
        try {
//            for (int i = 0; i < map.length; i++) {
//                for (int j = 0; j < map[0].length; j++) {
//                    s += map[i][j];
//                }
//                s += "\r\n";
//                System.err.print(s);
//                fw.write(s);
//                s = "";
//            }
            for(int[] i:map){
                for(int j:i){
                    s+=j;
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
