/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode67 {

    public static void main(String[] args) {
        Leetcode67 ad = new Leetcode67();
        System.out.println(ad.addBinary("11","1"));
    }

    public String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int l1 = a.length();
        int l2 = b.length();
        StringBuilder sb = new StringBuilder();
        boolean over = false;
        while (l1 >= 0 || l2 >= 0) {
            char num1 = --l1 >= 0 ? c1[l1] : '0';
            char num2 = --l2 >= 0 ? c2[l2] : '0';
            if (num1 == '1' && num2 == '1') {
                sb.append(over ? '1' : '0');
                over = true;
            } else if (num1 == '0' && num2 == '0') {
                sb.append(over ? '1' : '0');
                over = false;
            }else {
                sb.append(over ? '0' : '1');
            }
        }
        if(over)sb.append('1');
        return sb.reverse().toString();
    }
}
