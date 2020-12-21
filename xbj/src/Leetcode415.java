/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode415 {
    public static void main(String[] args) {
        new Leetcode415().addStrings("123", "123");
    }

    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        boolean isAdd = false;
        while (index1 >= 0 || index2 >= 0) {
            int num = 0;
            if (index1 >= 0) {
                num = num1.charAt(index1--) - '0';
            }
            if (index2 >= 0) {
                num += num2.charAt(index2--) - '0';
            }
            if (isAdd) ++num;
            isAdd = num > 9;
            sb.append(num % 10);
        }
        if(isAdd){
            sb.append("1");
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
