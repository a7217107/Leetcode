/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode59 {
    public static void main(String[] args) {
        new Leetcode59().generateMatrix(5);
    }

    public int[][] generateMatrix(int n) {
        if(n < 1)return new int[][]{};
        int[][] arr = new int[n][n];
        int lt[] = new int[]{0, 0, 1};
        int rt[] = new int[]{0, n - 1, n};
        int lb[] = new int[]{n - 1, 0, 3 * n - 2};
        int rb[] = new int[]{n - 1, n - 1, 2 * n - 1};
        if( n % 2 == 1){
            arr[n/2][n/2] = n * n;
        }
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < rt[1] - lt[1]; j++) {
                arr[lt[0]][lt[1] + j] = lt[2] + j;
                arr[rt[0] + j][rt[1]] = rt[2] + j;
                arr[rb[0]][rb[1] - j] = rb[2] + j;
                arr[lb[0] - j][lb[1]] = lb[2] + j;
            }
            ++lt[0];
            ++lt[1];
            lt[2] +=  4*(n-1-2*i);
            ++rt[0];
            --rt[1];
            rt[2] +=  4*(n-1-2*i)-2;
            --lb[0];
            ++lb[1];
            lb[2] +=  4*(n-1-2*i)-6;
            --rb[0];
            --rb[1];
            rb[2] +=  4*(n-1-2*i)-4;
        }
        return arr;
    }
}
