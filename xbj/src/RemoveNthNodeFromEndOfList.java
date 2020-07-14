import ListNode.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
        ListNode node = new ListNode(3);
        node.next = new ListNode(7);
        node.next.next = new ListNode(9);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(8);
        node.next.next.next.next.next.next = new ListNode(0);
        removeNthFromEnd(node, 1);
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode node = head;
        while (head.next != null) {
            head = head.next;
            count++;
        }
        head = node;
        if(count == n){
            return node.next;
        }
        for (int i = 0; i < count - n; i++) {
            if (i == count - n - 1) {
                head.next = head.next == null ? null : head.next.next;
            }else {
                head = head.next;
            }
        }
        return node;
    }
}
