import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode30 {
    public static void main(String[] args) {
        new Leetcode30().findSubstring("barfoothefoobarman"
                ,new String[]{"foo","bar"});
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>(words.length);
        HashMap<Integer, String> map = new HashMap<>();
        int i;
        for (String str : words) {
            if ((i = s.indexOf(str)) != -1) {
                list.add(i);
                map.put(i, str);
            } else {
                return new ArrayList<>();
            }
        }
        Collections.sort(list);
        StringBuilder builder = new StringBuilder();
        list.forEach(d -> {
            builder.append(map.get(d));
        });
        return s.contains(builder.toString()) ? list : new ArrayList<>();
    }
}
