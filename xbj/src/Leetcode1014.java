/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1014 {
    public static void main(String[] args) {
        System.out.println(new Leetcode1014().maxScoreSightseeingPair(new int[]{2,2,2}));
    }

    public int maxScoreSightseeingPair(int[] A) {
        int max = 0;
        int str = A[0];
        for(int i = 1;i< A.length;i++){
            str--;
            max = Math.max(max,A[i]+str);
            str = Math.max(str,A[i]);
        }
        return max;
    }
}
