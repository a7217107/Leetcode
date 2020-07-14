/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeIntervals {
    public static void main(String[] args) {
        new MergeIntervals().merge(new int[][]{{1, 4}, {2, 3}});
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        int[][] arr = new int[intervals.length][];


        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] ints = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = ints;
                }
            }
        }

        arr[0] = intervals[0];
        int index = 0;
        for (int[] item : intervals) {
            if (item[0] > arr[index][1]) {
                arr[++index] = item;
            } else if (item[0] <= arr[index][1] && item[1] > arr[index][1]) {
                arr[index][1] = item[1];
            }
        }
        int[][] result = new int[index + 1][];
        for (int i = 0; i < index + 1; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
