import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode32 {
    public static void main(String[] args) {
        new Leetcode32().longestValidParentheses("()(()");
    }

    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty() && c== ')') {
                continue;
            }
            if (c == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                    count++;
                    if (count << 1 > max) {
                        max = count << 1;
                    }
                } else {
                    if (count << 1 > max) {
                        max = count << 1;
                    } else {
                        count = 0;
                    }
                }
            } else {
                stack.push(c);
            }
        }
        return max;
    }
}
