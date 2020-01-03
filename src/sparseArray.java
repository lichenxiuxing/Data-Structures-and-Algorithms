/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/3
 * 14:43
 */
public class sparseArray {
    public static void main(String[] args) {
        int arr1[][] = new int[11][11];
        arr1[1][2] = 1;
        arr1[2][3] = 2;
        //打印原始数组
        for (int[] ints : arr1) {
            for (int i : ints) {

                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
        //循环遍历原始数组，记录信息
        int sum = 0;
        for (int[] ints : arr1) {
            for (int i : ints) {
                if (i != 0) {
                    sum++;
                }
            }
        }
        //将数组写入稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr1[i][j];
                }
            }
        }

        System.out.println("稀疏数组");
        for (int i = 0; i < sum + 1; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }
        //将稀疏数组写入原始数组
        int arr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i <sparseArr.length ; i++) {
            arr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        System.out.println("转换后的数组");
        for (int[] ints : arr1) {
            for (int i : ints) {

                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }
}
