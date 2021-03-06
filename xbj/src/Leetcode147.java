

/**
 * 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 *  
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode147 {
    public static void main(String[] args) {
        retry:
        for (;;){
            int i = 0;
            continue retry;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head.next;
        ListNode str = head;
        ListNode tail = head;
        while (node != null) {
            if (node != tail && node.val >= tail.val) {
                tail = node;
                node = node.next;
                continue;
            }
            if (node.val <= str.val) {
                tail.next = node.next;
                ListNode n = node;
                node = node.next;
                n.next = head;
                head = n;
                str = head;
                continue;
            }
            while (str.next.val < node.val) {
                str = str.next;
            }
            ListNode next = str.next;
            next.next = node.next;
            node.next = str.next;
            str.next = node;
            node = next.next;
            str = head;
        }
        return head;
    }
}
