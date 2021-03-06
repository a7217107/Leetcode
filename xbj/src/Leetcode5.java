/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        int str = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (i == 0) {
                    dp[j][j + i] = true;
                } else if (i < 3) {
                    dp[j][j + i] = s.charAt(j) == s.charAt(j + i);
                    if (dp[j][j + i] && i > max) {
                        max = i;
                        str = j;
                        end = j + i;
                    }
                } else {
                    dp[j][j + i] = s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1];
                    if (dp[j][j + i] && i > max) {
                        max = i;
                        str = j;
                        end = j + i;
                    }
                }
            }
        }
        return s.substring(str, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode5().longestPalindrome("abcba"));
    }
}
