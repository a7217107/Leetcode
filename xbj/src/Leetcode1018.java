import java.util.ArrayList;
import java.util.List;

/**
 *1018. 可被 5 整除的二进制前缀
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 *
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 *
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例 4：
 *
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * A[i] 为 0 或 1
 */
public class Leetcode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        if(A == null || A.length == 0)return new ArrayList<>(0);
        List<Boolean> res = new ArrayList<>(A.length);
        int num = 0;
        for(int a : A){
            num = (num*2 + a) % 10;
            res.add(num % 5 ==0);
        }
        return res;
    }

    public static void main(String[] args) {
        new Leetcode1018()
                .prefixesDivBy5(new int[]{1,0,0,1,0,1
                        ,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1});
    }
}
