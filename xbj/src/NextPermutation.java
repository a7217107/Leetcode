/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation {
    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{5,1,1});
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int index = nums.length - 1;
        while (index > 0 && nums[index] <= nums[--index]) {
        }
        boolean noBig = index == 0 && nums[index] >= nums[index + 1];
        if (!noBig) {
            for (int i = nums.length - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
        }
        sort(nums, noBig ? 0 : index + 1);
    }

    public void sort(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            int n = nums[i];
            nums[i] = nums[k];
            nums[k] = n;
        }
    }
}
