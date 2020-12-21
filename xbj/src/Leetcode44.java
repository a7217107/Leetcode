/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode44 {
    public static void main(String[] args) {
        new Leetcode44().isMatch("abefcdgiescdfimde", "ab*cd?i*de");
    }

    public boolean isMatch(String s, String p) {
        if (p.length() > s.length()) return false;
        int pIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (pIndex > p.length() - 1) return false;
            char sChar = s.charAt(i);
            char pChar = p.charAt(pIndex);
            if (sChar != pChar) {
                switch (pChar) {
                    case '?':
                        pIndex++;
                        continue;
                    case '*':
                        if (pIndex == p.length() - 1) return true;
                        pIndex++;
                        String pSub = p.substring(pIndex);
                        String sSub = s.substring(i);
                        int pNext = Math.min(pSub.indexOf('*'),pSub.indexOf("?"));
                        while (i < s.length() && s.charAt(i) != p.charAt(pIndex)) {
                            i++;
                        }
                        if (sSub.contains(pNext > 0 ? pSub.substring(0, pNext) : pSub)) {
                            i+=sSub.indexOf(pNext > 0 ? pSub.substring(0, pNext) : pSub);
                            pIndex+=pNext;
                        }
                        if (i == s.length()) {
                            return s.charAt(i - 1) == p.charAt(p.length() - 1);
                        }
                        continue;
                    default:
                        return false;
                }
            }
            pIndex++;
        }
        return true;
    }
}
