/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    // 前后指针法
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        boolean isFirst = true;
        while (node != null && node.next != null){
            ListNode next = node.next;
            node.next = next.next;
            next.next = node;
            if(isFirst){
                head = next;
                isFirst = false;
            }
            next = node.next;
            if(next!=null){
                node.next = next.next == null ? next : next.next;
                node = next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
