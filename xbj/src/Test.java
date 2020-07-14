public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.maximalSquare(new char[][]{{'0', '1'}, {'1', '0'}}));
    }


    public int maximalSquare(char[][] matrix) {
        if (matrix == null) return 0;
        int max = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                int top = matrix[i - 1][j] - '0';
                int left = matrix[i][j - 1] - '0';
                int leftTop = matrix[i - 1][j - 1] - '0';
                int num = Math.min(Math.min(left, top), leftTop) + 1;
                if (i == matrix.length - 1 || j == matrix[0].length - 1) {
                    if ( matrix[i][j] == '0') {
                        num = 0;
                    }
                }
                max = Math.max(num, max);
                matrix[i][j] = (char) (num + '0');
            }
        }
        return max * max;
    }


//    interface MountainArray {
//        int get(int index);
//
//        int length();
//    }
//
//    public int findInMountainArray(int target, MountainArray mountainArr) {
//        int high = mountainArr.length() - 1;
//        int low = 0;
//            boolean isTop = false;
//            while (low <= high) {
//                int mid = mountainArr.get((high - low) / 2);
//                if (target < mid && mountainArr.get((high - low) / 2) > mid) {
//
//                }
//                if (mid < target) {
//                    if (n < mountainArr.get(index + 1)) break;
//                }
//                index /= 2;
//            }
//    }
//
//    private int find(int target, MountainArray mountainArray, int left, int right) {
//        while (left <= right) {
//            int mid = (right + left) / 2;
//            int num = mountainArray.get(mid);
//            if (num == target) {
//                return mid;
//            } else if (num > target) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return -1;
//    }

}
