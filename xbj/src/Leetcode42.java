import java.util.Map;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode42 {

    public static void main(String[] args) {

        System.out.println(new Leetcode42().trap(new int[]{4,2,0,3,2,5}));
    }


    public int trap(int[] height) {
        if(height == null || height.length == 0)return 0;
        int num = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int leftValue = height[leftIndex];
        int rightValue = height[rightIndex];
        while (leftIndex < rightIndex) {
            while (leftValue >= height[rightIndex] && rightIndex > leftIndex){
                rightValue = Math.max(height[rightIndex],rightValue);
                num+=rightValue - height[rightIndex];
                rightIndex--;
                rightValue = Math.max(height[rightIndex],rightValue);
            }

            while (rightValue >=height[leftIndex] && leftIndex < rightIndex){
                leftValue = Math.max(height[leftIndex],leftValue);
                num+=leftValue - height[leftIndex];
                leftIndex++;
                leftValue = Math.max(height[leftIndex],leftValue);
            }
        }

        return num;
    }
}
