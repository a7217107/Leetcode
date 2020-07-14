import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertInterval {
    public static void main(String[] args) {
        new InsertInterval().insert(new int[][]{{1, 3},{6,9}}, new int[]{2, 5});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<Integer> list = new ArrayList<>();
        if(newInterval[1] < intervals[0][0]){
            list.add(newInterval[0]);
            list.add(newInterval[1]);
            for(int[] arr : intervals){
                list.add(arr[0]);
                list.add(arr[1]);
            }
            int[][] result = new int[list.size() / 2][2];
            for (int i = 0; i < list.size() / 2; i++) {
                result[i][0] = list.get(2 * i);
                result[i][1] = list.get(2 * i + 1);
            }
            return result;
        }

        int index = 0;
        int num = newInterval[0] - 1;


        for (int i = 0; i < intervals.length; i++) {
            if (num < newInterval[0] && newInterval[1] < intervals[i][0]) {
                list.add(newInterval[0]);
                list.add(newInterval[1]);
                num = intervals[i][1];
                continue;
            }
            num = intervals[i][1];

            list.add(intervals[i][0]);
            list.add(intervals[i][1]);

            if (newInterval[0] <= intervals[i][1]) {
                list.remove(list.size() - 1);
                index = i;
                break;
            }
        }
        while (index < intervals.length && intervals[index][1] < newInterval[1]) {
            index++;
        }
        if (index == 0) {
            if (newInterval[0] < intervals[0][0]) {
                intervals[0][0] = newInterval[0];
            }
            return intervals;
        }

        if ((index == intervals.length && newInterval[1] > intervals[index - 1][1])
                || (index < intervals.length && intervals[index][0] > newInterval[1])) {
            if(newInterval[0] < intervals[0][0]){
                list.remove(0);
                list.add(newInterval[0]);
            }
            list.add(newInterval[1]);
        }
        for (int i = index; i < intervals.length; i++) {
            if (i == index && (intervals[index][0] == newInterval[1] ||  newInterval[1]<intervals[i][1])) {
                list.add(intervals[i][1]);
                continue;
            }
            list.add(intervals[i][0]);
            list.add(intervals[i][1]);
        }
        if (intervals[index - 1][1] > newInterval[1]) {
            list.add(intervals[index - 1][1]);
        }
        if (intervals[intervals.length - 1][1] < newInterval[0]) {
            list.remove(list.size() - 1);
            list.add(newInterval[0]);
            list.add(newInterval[1]);
        }

        int[][] result = new int[list.size() / 2][2];
        for (int i = 0; i < list.size() / 2; i++) {
            result[i][0] = list.get(2 * i);
            result[i][1] = list.get(2 * i + 1);
        }
        return result;
    }
}
