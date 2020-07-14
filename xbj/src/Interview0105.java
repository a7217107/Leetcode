/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 */
public class Interview0105 {
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        char[] c1 = first.toCharArray();
        char[] c2 = second.toCharArray();
        if (c1.length == 0 || c2.length == 0) return true;
        boolean isDif = false;
        int node1 = 0;
        int node2 = 0;
        for (int i = 0; i < Math.max(c1.length, c2.length); i++) {
            if(node1 == c1.length || node2 == c2.length) return !isDif;
            if (c1[node1] != c2[node2]) {
                if (isDif) return false;
                isDif = true;
                if (c1.length == c2.length) {
                    return false;
                } else if (c1.length > c2.length) {
                    node2--;
                } else {
                    node1--;
                }
            }
            node1++;
            node2++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Interview0105().oneEditAway("islander", "slander"));
    }
}
