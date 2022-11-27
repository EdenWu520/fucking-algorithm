package site.leiwa.leetcode;


// 剑指 Offer II 018

/**
 * @see <a href="https://leetcode.cn/problems/XltzEq/">剑指 Offer II 018. 有效的回文</a>
 */

public class LC_Offer_II_018_ValidPalindrome {

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = ".,@#$%";
        String s3 = "0P";
        System.out.println(new LC_Offer_II_018_ValidPalindrome().isPalindrome(s1));

    }


    public boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            while (i < str.length() - 1 && !Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            }
            while (j > 0 && !Character.isLetterOrDigit(str.charAt(j))) {
                j--;
            }
            if (i < j && Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
