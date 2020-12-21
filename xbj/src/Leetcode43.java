/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode43 {
    public static void main(String[] args) {
        new Leetcode43().multiply("123", "456");
    }

    public String multiply(String num1, String num2) {
        String zero = "0";
        if (zero.equals(num1) || zero.equals(num2)) return zero;
        int length1 = num1.length();
        int length2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int high = 0;
        for (int i = 0; i < length1 + length2; i++) {
            int n1 = 0, n2 = 0;
            int num = 0;
            for (int j = length1 - 1; j >= 0; j--) {
                if (i >  j + length2 - 1 || j > i) {
                    continue;
                }
                n1 = (int) num1.charAt(length1 - 1 - j) - 48;
                n2 = (int) num2.charAt( length2 -1 - i +j) - 48;
                num += n1 * n2;
            }
            num += high;
            int mul = num;
            high = mul / 10;
            sb.append(mul % 10);
            if(i == length1+length2-1 && mul == 0){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.reverse().toString();
    }
}
