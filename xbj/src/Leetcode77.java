import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Leetcode77 {
    public static void main(String[] args) {
        new Leetcode77().combine(4, 3)
                .forEach(d ->
                        System.out.println(StringUtils.join(d, ","))
                );
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                res.add(Collections.singletonList(i + 1));
            }
            return res;
        }
        if (n == k) {
            res.add(new ArrayList<>(k));
            for (int i = 0; i < k; i++) {
                res.get(0).add(i + 1);
            }
            return res;
        }
        for (int i = 1; i <= n - k + 1; i++) {
            build(res, Collections.singletonList(i), i + 1, i + 1, n, k);
        }
        return res;
    }

    private void build(List<List<Integer>> res, List<Integer> list, Integer add, Integer str, Integer end, Integer count) {
        if (list.contains(add) || list.size() == count) return;
        for (Integer i = str; i <= end; i++) {
            List<Integer> copy = new ArrayList<>(list);
            copy.add(i);
            if (copy.size() == count) {
                res.add(copy);
            } else {
                build(res, copy, i + 1, i + 1, end, count);
            }
        }
    }
}
