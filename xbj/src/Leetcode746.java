/**
 *746. 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 */
public class Leetcode746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1)return cost[0];
        if(cost.length == 2)return Math.min(cost[0],cost[1]);
        int[] res = new int[cost.length];
        res[0] = cost[0];
        res[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            res[i] = Math.min(res[i-1],res[i-2]) + cost[i];
        }
        return Math.min(res[res.length-1],res[res.length-2]);
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
