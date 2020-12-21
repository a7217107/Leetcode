import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode25 {
    public static void main(String[] args) {
        Leetcode25 test = new Leetcode25();
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        test.reverseKGroup(n,3);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        if(head == null || k<1)return null;
        ListNode result = null;
        list.add(head);
        int index = 0;
        while (head != null) {
            if (result == null && index + 1 == k) {
                result = head;
            }
            head = head.next;
            if (++index == k) {
                list.add(head);
                index = 0;
            }
        }
        for (int i = 0; i < list.size()-1; i++) {
            ListNode node = list.get(i);
            ListNode next = node.next;
            ListNode tail = null;
            if (next != null) {
                tail = next.next;
                for (int j = 1; j < k; j++) {
                    next.next = node;
                    node = next;
                    next = tail;
                    if(next == null)break;
                    tail = next.next;
                }
            }
            if (i > 0) {
                list.get(i - 1).next = node;
            }
        }
        if(list.size()>1)
        list.get(list.size() - 2).next = list.get(list.size()-1);
        return result == null ? list.get(0) : result;
    }
}
