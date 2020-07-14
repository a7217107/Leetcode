/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode7 {

    public static void main(String[] args) {
        Leetcode7 test = new Leetcode7();
        System.out.println(test.reverse(1534236469));
    }

    public int reverse(int x) {
        boolean bool = x < 0;
        if(bool)x=-x;
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        int num = 0;
        try {
            num = Integer.parseInt(sb.toString());
        }catch (Exception e){

        }
        return bool ? -num : num;
    }

}
