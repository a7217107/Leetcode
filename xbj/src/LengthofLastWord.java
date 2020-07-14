/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        int index = s.lastIndexOf(' ');
        if(index == -1)return s.length();
        if (s.length() - 1 == index) {
            int length = 0;
            while (index > 0 && s.charAt(index-1) == ' '){
                index--;
            }
            while (index > 0 && s.charAt(index-1)!=' '){
                index--;
                length++;
            }
            return length;
        } else {
            return s.length() - 1 - index;
        }
    }

    public static void main(String[] args) {
        new LengthofLastWord().lengthOfLastWord("a     b   ");
    }
}
