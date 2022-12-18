package site.leiwa.leetcode.string;

/**
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/string-to-integer-atoi/">字符串转换整数</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/11
 */
public class LC8_MyAtoi {
    public static void main(String[] args) {
        System.out.println(new LC8_MyAtoi().myAtoi("-42"));
    }

    public int myAtoi(String s) {
        int ans = 0;
        if (s == null || s.trim().isEmpty()) {
            return ans;
        }
        String str = s.trim();
        int right = 0;
        for (int i = 0; i < str.length(); i++) {
            // 前导 + 或者 -
            if (i == 0 && ((str.charAt(i) == '+') || str.charAt(i) == '-')) {
                continue;
            }

            if (Character.isDigit(str.charAt(i))) {
                right = i + 1;
                continue;
            }
            break;
        }
        String numString = str.substring(0, right);

        if (numString.isEmpty()) {
            return 0;
        }

        // 溢出相关使用 BigDecimal 解决
        // BigDecimal maxNumStr = new BigDecimal(Integer.MAX_VALUE);
        // BigDecimal minNumStr = new BigDecimal(Integer.MIN_VALUE);
        // BigDecimal inputNum = new BigDecimal(numString);
        //
        // if (inputNum.compareTo(maxNumStr) > 0) {
        // return maxNumStr.intValue();
        // }
        //
        // if (inputNum.compareTo(minNumStr) < 0) {
        // return minNumStr.intValue();
        // }
        // return inputNum.intValue();

        return Integer.valueOf("12312312312312312312");
    }
}
