import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode16 {
    public static void main(String[] args) {
        new Leetcode16().threeSumClosest(new int[]{-1,2,1,-4},1);
    }
    public int threeSumClosest(int[] nums, int target) {
        int min = Math.abs(nums[0]+nums[1]+nums[2]-target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = Math.abs(nums[i] + nums[left] + nums[right]-target);
                if (sum != min) {
                    min = Math.min(min,sum);
                    left++;
                    right--;
                }
                if (sum < 0) left++;
                if (sum > 0) right--;
            }
        }
        return min;
    }
}
