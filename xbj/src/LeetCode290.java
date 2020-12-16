import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 */
public class LeetCode290 {
    public static void main(String[] args) {

    }

    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (chars.length != strings.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>(chars.length);
        List<String> have = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == null) {
                if (!have.contains(strings[i])) {
                    map.put(chars[i], strings[i]);
                    have.add(strings[i]);
                } else {
                    return false;
                }
            } else {
                if (!map.get(chars[i]).equals(strings[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
