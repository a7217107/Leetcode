import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {

    private static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        new Permutations().permute(new int[]{1,2,3});
    }
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums,list);
        return lists;
    }
    private void backtrack(int[] nums,List<Integer> list){
        if(nums.length == list.size()){
            lists.add(new LinkedList<>(list));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(list.contains(nums[i]))continue;
            list.add(nums[i]);
            backtrack(nums,list);
            list.remove(list.size()-1);
        }
    }
}
