import javax.sound.midi.Soundbank;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/8
 * 15:44
 */
public class MiGong {
    public static void main(String[] args) {
        //生成一个迷宫地图
        int[][] migong = new int[8][7];
        for (int i = 0; i < 8; i++) {
            migong[i][0] = 1;
            migong[i][6] = 1;
        }
        for (int i = 0; i < 7; i++) {
            migong[0][i] = 1;
            migong[7][i] = 1;
        }
        migong[3][1] = 1;
        migong[3][2] = 1;
        System.out.println("生成的迷宫是");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(migong[i][j] + " ");
            }
            System.out.println();
        }
        findWay(migong, 1, 1);
        System.out.println("生成的迷宫路径是");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf(migong[i][j] + " ");
            }
            System.out.println();
        }

    }

    //递归解决迷宫问题
    public static boolean findWay(int[][] map, int i, int j) {
        //设置边界条件
        if (map[6][5] == 2) {
            return true;
            //设置递归条件
        } else if (map[i][j] == 0) {
            map[i][j] = 2;
            if (findWay(map, i + 1, j)) {
                return true;
            } else if (findWay(map, i, j + 1)) {
                return true;
            } else if (findWay(map, i - 1, j)) {
                return true;
            } else if (findWay(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        }
        return false;
    }
}
