package site.leiwa.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/11
 */
public class LC722_RemoveComments {

    public static void main(String[] args) {
        System.out.println(new LC722_RemoveComments().removeComments(new String[] {"/**/e*//f"}));
    }

    public List<String> removeComments(String[] source) {
        boolean multiline = false;
        List<String> ans = new ArrayList<>();
        String tmpString = "";
        for (String sourceString : source) {
            StringBuilder validString = new StringBuilder();
            // 取有效的字符串[left, right)
            int left = 0;
            int right = 0;

            for (int j = 2; j <= sourceString.length(); j++) {
                // 单行注释的情况
                if (!multiline && "//".equals(sourceString.substring(j - 2, j))) {
                    // 忽略当前行后面的所有内容，取忽略前的内容
                    // 截取 // 前面的内容, 肯定就进入下一行的内容去截取了
                    validString.append(sourceString, left, right);
                    // 重置指针位置
                    right = sourceString.length();
                    left = right;
                    break;
                }

                // 行注释的情况
                if (!multiline && "/*".equals(sourceString.substring(j - 2, j))) {
                    multiline = true; // 标记多行注释
                    validString.append(sourceString, left, right);
                    // 指针前移
                    left = j;
                    right = left;
                    j += 1;
                    continue;
                }

                // 处理多行的闭合 */
                if (multiline && "*/".equals(sourceString.substring(j - 2, j))) {
                    left = j;
                    right = left;
                    multiline = false;
                    j += 1;
                    continue;
                }
                if (multiline) {
                    left = j;
                }
                right++;
            }

            // 多放注释的时候，可能会有有效字符没有被切到的情况，这里补一下
            validString.append(sourceString.substring(left));

            // 上一行是多行注释，后面的要连接前面的一行， 首先把多行注释的前一行放在tmpString中，处理然后直接处理下一行
            if (multiline) {
                tmpString += validString.toString();
            } else {
                if ((tmpString + validString.toString()).isEmpty()) {
                    continue;
                }
                ans.add(tmpString + validString.toString());
                tmpString = ""; // 复原tmpString
            }
        }
        return ans;
    }
}
