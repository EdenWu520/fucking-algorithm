package site.leiwa.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/most-profit-assigning-work/">安排工作以达到最大收益</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/18
 */
public class LC826_MaxProfitAssignment {

    public static void main(String[] args) {
        System.out.println(new LC826_MaxProfitAssignment().maxProfitAssignment(new int[] {2, 3}, new int[] {10, 20},
            new int[] {6, 2, 3}));
    }

    static class Worker {
        int difficulty;
        int profit;
        int bestProfit;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // 对工作难度和收益进行组装排序
        Worker[] workers = new Worker[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            Worker worker1 = new Worker();
            worker1.difficulty = difficulty[i];
            worker1.profit = profit[i];
            worker1.bestProfit = profit[i];
            workers[i] = worker1;
        }
        Arrays.sort(workers, Comparator.comparingInt(o -> o.difficulty));

        // 修正工作难度对应的最佳收益
        for (int i = 1; i < workers.length; i++) {
            // 获取前一个工作难度对应的最佳收益
            Worker prevWorker = workers[i - 1];
            // 当前的最佳收益
            Worker curWorker = workers[i];
            if (prevWorker.bestProfit > curWorker.bestProfit) {
                curWorker.bestProfit = prevWorker.bestProfit;
            }
        }

        // 计算工人的收益
        int ans = 0;
        for (int curWork : worker) {
            // 当前工人的能力
            // 匹配最接近能力的收益
            for (int j = workers.length - 1; j >= 0; j--) {
                if (workers[j].difficulty <= curWork) {
                    ans += workers[j].bestProfit;
                    break;
                }
            }
        }
        return ans;
    }
}
