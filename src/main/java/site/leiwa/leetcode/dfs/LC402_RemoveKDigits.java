package site.leiwa.leetcode.dfs;

import java.util.List;
import java.util.Stack;

/**
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/">矩阵中的最长递增路径</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/17
 */
public class LC402_RemoveKDigits {

    public static void main(String[] args) {
        // "1678999", 3
        System.out.println(new LC402_RemoveKDigits().removeKdigits("21200", 2));
    }

    public String removeKdigits(String num, int k) {
        if (num == null || k >= num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        int retain = num.length() - k;
        for (char ch : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        StringBuilder builder = new StringBuilder();
        for (Character ch : stack) {
            builder.append(ch);
        }

        String tmp = builder.toString();
        tmp = tmp.substring(0, retain);
        // 干掉前导 0
        int start;
        for (start = 0; start < tmp.length(); start++) {
            if (tmp.charAt(start) != '0') {
                break;
            }
        }
        String ansString = tmp.substring(start);
        return "".equals(ansString) ? "0" : ansString;
    }

    // 暴力枚举
    private void dfs(char[] numArray, int curIndex, int k, String s, List<String> ans) {
        if (k == s.length()) { // 说明满足长度了
            ans.add(s);
            return;
        }

        for (int i = curIndex; i < numArray.length; i++) {
            s += numArray[i];
            dfs(numArray, i + 1, k, s, ans);
            s = s.substring(0, s.length() - 1);
        }
    }

}
