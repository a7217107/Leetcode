/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode125 {
    public static void main(String[] args) {
        System.out.println(new Leetcode125().isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        int str = 0;
        int end = s.length() - 1;
        if (str == end) return true;
        char[] ch = s.toCharArray();
        while (str <= end) {
            while (!(ch[str] >= '0' && ch[str] <= '9' || (ch[str] >= 'a' && ch[str] <= 'z') || (ch[str] >= 'A' && ch[str] <= 'Z'))) {
                if (str == end) return true;
                str++;
            }
            while (!(ch[end] >= '0' && ch[end] <= '9' || (ch[end] >= 'a' && ch[end] <= 'z') || (ch[end] >= 'A' && ch[end] <= 'Z'))) {
                if (str == end) return true;
                end++;
            }
            if (ch[str] == ch[end] || ch[str] + 32 == ch[end] || ch[str] == ch[end] + 32) {
                str++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }

}
