package site.leiwa.leetcode.two_pointers;

/**
 * @desc: 注意点在提示中花品种的数量，可以不用map的结构去记录不同品种的数量
 * 
 * @see <a href="https://leetcode.cn/problems/1GxJYY/description/">美观的花束</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/3
 */

public class LCP68_BeautifulBouquet {
    public int beautifulBouquet(int[] flowers, int cnt) {
        // 用于记录不同品种对应的数量
        int[] kinds = new int[(int)10e5 + 1];
        int left;
        int right;
        int ans = 0;
        int mod = (int)(1e9 + 7);
        for (left = 0, right = 0; right < flowers.length && left < flowers.length;) {
            while (right < flowers.length && kinds[flowers[right]] < cnt) {
                kinds[flowers[right]]++;
                right++;
            }
            right--;
            kinds[flowers[right]]--;
            // 上面的区间才是有效区间 [left, right]

            ans += (right - left + 1) % mod;
            kinds[flowers[left]]--;
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LCP68_BeautifulBouquet().beautifulBouquet(new int[] {1, 2, 3, 4, 5}, 4));
    }
}
