package site.leiwa.leetcode.dfs;

/**
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/fair-distribution-of-cookies/">公平分发饼干</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/17
 */
public class LC2305_FairDistributionOfCookies {

    public static void main(String[] args) {
        System.out.println(new LC2305_FairDistributionOfCookies().distributeCookies(new int[] {8, 15, 10, 20, 8}, 2));

    }

    static class Ans {
        // 存储当前给第K个孩子分配的饼干数量
        int[] cookie = new int[8];
        int unfairness = Integer.MAX_VALUE;
    }

    public int distributeCookies(int[] cookies, int k) {
        Ans ans = new Ans();
        dfs(cookies, k, 0, ans);
        return ans.unfairness;
    }

    private void dfs(int[] cookies, int k, int curCookiesIndex, Ans ans) {
        if (curCookiesIndex == cookies.length) {
            // 饼干已经分配完成
            int max = 0;
            for (int i = 0; i < k; i++) {
                // 获取当前孩子饼干的最大值
                max = Math.max(max, ans.cookie[i]);
            }
            // 获取分配下来的饼干数量的最小值
            ans.unfairness = Math.min(ans.unfairness, max);
            return;
        }

        for (int i = 0; i < k; i++) {
            ans.cookie[i] += cookies[curCookiesIndex];
            dfs(cookies, k, curCookiesIndex + 1, ans);
            ans.cookie[i] -= cookies[curCookiesIndex];
        }
    }
}
