import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//生成地图，暂时没想好怎么写比较好
public class BuildMap {
    BuildMap(int[][]mapSize,int[][]xLine,int[][]yLine){
        int mapNum = 1;
        StringBuilder s = new StringBuilder("");
        String fileAddress = "maps\\" + mapNum + ".txt";
        FileWriter fw;
        try {
            fw = new FileWriter(fileAddress);
            for(int i=0;i<mapSize.length;i++){
                for(int j = 0;j<mapSize[0].length;j++){
                    s.append(mapSize[i][j]);
                }
                s.append("\r\n");
                fw.write(s.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
