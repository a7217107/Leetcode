/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Leetcode206 {

    public int maxSubArray(int[] nums) {
        int max = 0;
        int sum = nums[0];
        for (int i = 1;i<nums.length;i++){
            sum = sum > 0 ? sum + nums[0] : nums[0];
            max = Math.max(max,sum);
        }
        return max;
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode node = head;
        ListNode next = head.next;
        while (next != null) {
            node.next = pre;
            pre = node;
            node = next;
            next = next.next;
            node.next = pre;
        }
        return node;
    }

}
