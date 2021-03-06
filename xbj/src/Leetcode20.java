import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode20 {
    public static void main(String[] args) {
        new Leetcode20().isValid("([)]");
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        List<Character> left = Arrays.asList('(', '[', '{');
        List<Character> right = Arrays.asList(')', ']', '}');
        for (Character c : s.toCharArray()) {
            if (right.contains(c)) {
                if (stack.empty() || !isOk(left, right, c, stack.pop())) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    private boolean isOk(List<Character> left, List<Character> right, Character c1, Character c2) {
        if (!right.contains(c1)) return false;
        return right.indexOf(c1) == left.indexOf(c2);
    }
}
