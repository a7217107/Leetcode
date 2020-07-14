import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode4 {
    public static void main(String[] args) {
        Leetcode4 test = new Leetcode4();
        test.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>(nums1.length+nums2.length);
        list.addAll(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        list.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        Collections.sort(list);
        return list.size() % 2 == 0 ? (list.get(list.size() / 2) + list.get(list.size() / 2 - 1))*1.0 / 2 :
                list.get(list.size()/2);
    }
}
