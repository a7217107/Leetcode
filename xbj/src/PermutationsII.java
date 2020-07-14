import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationsII {

    private static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        new PermutationsII().permuteUnique(new int[]{1,2,3});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums,list,-1);
        return lists;
    }

    private void backtrack(int[] nums,List<Integer> list,int index){
        if(nums.length == list.size()){
            lists.add(new LinkedList<>(list));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(i == index)continue;
            list.add(nums[i]);
            backtrack(nums,list,i);
            list.remove(list.size()-1);
        }
    }
}
