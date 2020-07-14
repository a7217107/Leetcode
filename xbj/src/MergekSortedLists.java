import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1)return null;
        List<Integer> list = new ArrayList<>();
        for(ListNode n : lists){
            list.add(n.val);
            while (n.next!=null){
                n = n.next;
                list.add(n.val);
            }
        }
        Collections.sort(list);
        if(list.size()<1)return null;
        ListNode head = new ListNode(list.get(0));
        ListNode node = head;
        int i = 0;
        for(Integer d : list){
            if(i == 0){
                i++;
                continue;
            }
            node.next = new ListNode(d);
            node = node.next;
            i++;
        }
        return head;
    }

}
