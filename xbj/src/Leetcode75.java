/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode75 {
    public static void main(String[] args) {
        new Leetcode75().sortColors(new int[]{2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                if(i > left) {
                    int t = nums[i];
                    nums[i] = nums[left];
                    nums[left] = t;
                    i--;
                }
                left++;
            }
            if(nums[i] == 2){
                if(i < right){
                    int t = nums[i];
                    nums[i] = nums[right];
                    nums[right] = t;
                    i--;
                }
                right--;
            }
        }
    }
}
