package site.leiwa.leetcode;


// 剑指 Offer II 018

import java.util.Optional;

/**
 * @see <a href="https://leetcode.cn/problems/RQku0D/">剑指 Offer II 019. 最多删除一个字符得到回文</a>
 */

// 模拟不会过(n^2)
// 双指针(n)
public class LC_Offer_II_019_ValidPalindrome {

    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "abca";
        String s3 = "abc";
        System.out.println(new LC_Offer_II_019_ValidPalindrome().validPalindrome1(s2));
    }


    public boolean validPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        boolean flagStart = true; // 用于记录不是回文字符串的开始index
        boolean flagEnd = true; // 用于记录不是回文字符串的结束index
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else { // 说明此时不相等
                // 这里是去头还是去尾
                for (int i = start + 1, j = end; i < j; i++, j--) {
                    if (str.charAt(i) != str.charAt(j)) {
                        // 标记flag
                        flagStart = false;
                        break;
                    }
                }
                for (int i = start, j = end - 1; i < j; i++, j--) {
                    if (str.charAt(i) != str.charAt(j)) {
                        // 标记flag
                        flagEnd = false;
                        break;
                    }
                }
                break;
            }
        }
        return flagEnd || flagStart || start >= end;
    }

    static class Pair {
        int left;
        int right;

        public Pair(int i, int j) {
            this.left = i;
            this.right = j;
        }
    }

    public boolean validPalindrome1(String str) {
        Optional<Pair> pair = findDifferent(str);
        if (pair.isEmpty()){
            return true;
        }
        Pair pair1 = pair.get();
        return isPalindrome(str.substring(pair1.left, pair1.right)) || isPalindrome(str.substring(pair1.left + 1, pair1.right + 1));
    }

    private Optional<Pair> findDifferent(String str) {
        for (int i = 0, j = str.length() - 1; i < j;) {
            if (str.charAt(i) != str.charAt(j)) {
                return Optional.of(new Pair(i, j));
            }
            i++;
            j--;
        }
        return Optional.empty();
    }


    private boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
