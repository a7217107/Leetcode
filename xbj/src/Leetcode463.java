import java.util.Arrays;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 *  
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 * <p>
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode463 {
    public static void main(String[] args) {
        System.out.println(new Leetcode463().islandPerimeter(new int[][]{new int[]{0,1,0,0},new int[]{1,1,1,0},
                new int[]{0,1,0,0},
                new int[]{1,1,0,0}}));
    }

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    res+=nearCount(grid,i,j);
                }
            }
        }
        return res;
    }

    private int nearCount(int[][] arr, int x, int y) {
        int res = 4;
        if (x > 0 && arr[x - 1][y] == 1) {
            res--;
        }
        if (x < arr.length - 1 && arr[x + 1][y] == 1) {
            res--;
        }
        if (y > 0 && arr[x][y - 1] == 1) {
            res--;
        }
        if (y < arr[0].length-1 && arr[x][y + 1] == 1) {
            res--;
        }
        return res;
    }

}
