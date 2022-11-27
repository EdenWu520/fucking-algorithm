package site.leiwa.leetcode;


/**
 * @see <a href="https://leetcode.cn/problems/longest-palindromic-substring/">最长回文子串</a>
 */
// 模拟，时间O(n^3)
public class LC5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "bb";
        String s3 = "cbbd";
        String s4 = "ac";
        String s5 = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftu" +
                "hawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtr" +
                "avwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbx" +
                "qxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
        System.out.println(new LC5_LongestPalindromicSubstring().longestPalindrome(s5));

    }


    public String longestPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        int begin = 0;
        int maxLength = 0;
        char[] strChar = str.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            for (int j = i + 1; j <= strChar.length; j++) {
                if (j - i > maxLength - begin && validate(strChar, i, j)) {
                    begin = i;
                    maxLength = j;
                }
            }
        }
        return str.substring(begin, maxLength);
    }


    /**
     * 验证字符串时候为回文子串
     * 闭区间 [start,end]
     */
    boolean validate(char[] strChars, int start, int end) {
        if (strChars == null || strChars.length == 0) {
            return false;
        }
        for (int i = start, j = end - 1; i < j; i++, j--) {
            if (strChars[i] != strChars[j]) {
                return false;
            }
        }
        return true;
    }
}
