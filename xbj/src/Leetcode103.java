import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode103 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        new Leetcode103().zigzagLevelOrder(node);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        toList(res, 0, root);
        for (int i = 1; i < res.size(); i += 2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }

    private void toList(List<List<Integer>> res, int i, TreeNode node) {
        if (node == null) return;
        if (res.size() == i) {
            res.add(new ArrayList<>());
        }
        List<Integer> list = res.get(i);
        list.add(node.val);
        toList(res, i + 1, node.left);
        toList(res, i + 1, node.right);
    }
}
