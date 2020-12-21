/**
 * 面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 */
public class Interview0801 {
    public int waysToStep(int n) {
        long[] arr = new long[n];
        for(int i = 0 ;i<n;i++){
            arr[i] = num(arr,i);
        }
        return (int)(arr[n-1] % 1000000007);
    }

    private long num(long [] arr,int i){
        if(i == 0) return 1L;
        if(i == 1) return 2L;
        if(i == 2)return 4L;
        return arr[i-3]+arr[i-2]+arr[i-1];

    }
}
