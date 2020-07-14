/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        boolean isOver = false;
        if (sum >= 10) {
            sum -= 10;
            isOver = true;
        }
        ListNode node = new ListNode(sum);
        ListNode tail = node;
        while (l1.next != null || l2.next != null ||isOver) {
            int num1 = 0;
            int num2 = 0;
            if (l1.next != null) {
                l1 = l1.next;
                num1 = l1.val;
            }
            if (l2.next != null) {
                l2 = l2.next;
                num2 = l2.val;
            }
            sum = isOver ? num1 + num2 + 1 : num1 + num2;
            if (sum >= 10) {
                sum -= 10;
                isOver = true;
            } else {
                isOver = false;
            }
            tail.next = new ListNode(sum);
            tail = tail.next;
        }
        return node;
    }

    public static void main(String[] args) {
        Leetcode2 test = new Leetcode2();
        ListNode node1 = new ListNode(5);
//        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);
        test.addTwoNumbers(node1, node2);
    }


}
