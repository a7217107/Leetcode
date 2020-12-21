/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode680 {
    public static void main(String[] args) {
        new Leetcode680().validPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu");
    }

    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 1) return true;
        char[] chars = s.toCharArray();
        int index = 0;
        int end = chars.length - 1;
        return vaild(chars, false, index, end);
    }

    private boolean vaild(char[] chars, boolean b, int index, int end) {
        while (index <= end) {
            if (chars[index] == chars[end]) {
                index++;
                end--;
            } else {
                if (b) return false;
                return vaild(chars, true, index + 1, end) || vaild(chars, true, index, end - 1);
            }
        }
        return true;
    }
}
