import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumII {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        new CombinationSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        sum(candidates, 0, 0, target, list);
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (Arrays.equals(result.get(i).toArray(), result.get(j).toArray())) {
                    result.remove(j);
                    j--;
                }
            }
        }
        return result;
    }

    public void sum(int[] arr, int index, int sum, int target, List<Integer> list) {
        if (index > arr.length || sum > target) return;
        if (sum == target) result.add(new ArrayList<>(list));
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            sum(arr, i + 1, sum + arr[i], target, list);
            list.remove(list.size() - 1);
        }
    }
}
