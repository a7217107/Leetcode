/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode14 {
    public static void main(String[] args) {
        System.out.println(new Leetcode14().longestCommonPrefix(new String[]{"aca","cba"}));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < prefix.length() && j<strs[i].length(); j++) {
                if (prefix.charAt(j) == strs[i].charAt(j)) {
                    sb.append(prefix.charAt(j));
                }else {
                    break;
                }
            }
            prefix = sb.toString();
            sb.delete(0,sb.length());
        }
        return prefix;
    }
}
