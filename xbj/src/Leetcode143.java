

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode143 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        new Leetcode143().reorderList(node);
    }
    public void reorderList(ListNode head) {
        if (head==null || head.next ==null || head.next.next == null)return;
        ListNode half = head;
        ListNode tail = head;
        while(tail!=null && tail.next!=null){
            half = half.next;
            tail = tail.next.next;
        }
        ListNode next = half.next;
        half.next = null;
        while(next!=null){
            tail = next;
            next = next.next;
            tail.next = half;
            half = tail;
        }
        next = head;
         while(next!=null && next.next!=null){
             tail = next.next;
             next.next = half;
             next = half.next;
             half.next = tail;
             if(next!=null && next.next!=null){
                 half = next;
                 next = tail;
             }
         }
    }
}
