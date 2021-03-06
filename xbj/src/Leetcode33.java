/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode33 {
    public static void main(String[] args) {
        System.out.println(new Leetcode33().search(new int[]{3,1
        },6));
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length < 1)return -1;
        if(nums.length == 1 && nums[0] == target)return 0;
        int mid = -1;
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            if(left == right -1 ){
                if(nums[left] == target)return left;
                if(nums[right] == target)return right;
                return -1;
            }
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if(nums[mid]>nums[left]){
                if(target>nums[mid] || target<nums[left]){
                    left = mid;
                }else {
                    right = mid;
                }
            }else {
                if(target<nums[mid] || target>nums[right]){
                    right = mid;
                }else{
                    left = mid;
                }
            }
        }
        return -1;
    }
}
