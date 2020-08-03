import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode54 {
    public static void main(String[] args) {
        new Leetcode54().spiralOrder(new int[][]{{1,2,3}, {4,5,6},{ 7, 8, 9}});
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int flag = (Math.min(matrix.length+1, matrix[0].length + 1)) / 2;
        int time = 0;
        int x = 0;
        int y = 0;
        while (time < flag) {
            while (x < matrix[time].length - time) {
                list.add(matrix[y][x++]);
                if (x == matrix[time].length - time) {
                    x--;
                    break;
                }
            }
            while (y < matrix.length - 1 - time) {
                list.add(matrix[++y][x]);
            }
            if (x == time || y == time) break;
            while (x > time) {
                list.add(matrix[y][--x]);
            }
            while (y > time + 1) {
                list.add(matrix[--y][x]);
            }
            time++;
            x++;
        }
        return list;
    }
}
