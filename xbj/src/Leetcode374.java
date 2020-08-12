public class Leetcode374 {
    public static void main(String[] args) {
        System.out.println(new Leetcode374().guessNumber(2126753390));
    }
    public int guessNumber(int n) {
        int left = 1 ;
        long right = n;
        int mid = (int)((left+right)/2);
        while(mid < right){
            int res = guess(mid);
            if(res == 0)return mid;
            if(res < 0){
                right = mid - 1;
                mid = (int)((left+right) /2) ;
            }else{
                left = Math.min(Integer.MAX_VALUE,mid + 1);
                mid = (int)((left + right) / 2);
            }
        }
        return mid;
    }
    private int guess(int num){
        return Integer.compare(1702766719,num);
    }
}
