package site.leiwa.leetcode.dfs;

/**
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/">矩阵中的最长递增路径</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/11
 */
public class LC329_LongestIncreasingPath {

    public static void main(String[] args) {
        System.out.println(new LC329_LongestIncreasingPath()
            .longestIncreasingPath(new int[][] {{7, 6, 1, 1}, {2, 7, 6, 0}, {1, 3, 5, 1}, {6, 6, 3, 2}}));

        // new int[][] {{7, 6, 1, 1}, {2, 7, 6, 0}, {1, 3, 5, 1}, {6, 6, 3, 2}}
        // new int[][]{{9,9,4},{6,6,8},{2,1,1}}
        // [[7,6,1,1],
        // [2,7,6,0],
        // [1,3,5,1],
        // [6,6,3,2]]
    }

    static class Ans {
        int curAns; // 当前方案的值
        int bestAns; // 最佳答案
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] direction = new int[][] {{-1, 0}, // 上
            {1, 0}, // 下
            {0, -1}, // 左
            {0, 1} // 右
        };
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        Ans currentAns = new Ans();
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                currentAns.bestAns = 0;
                currentAns.curAns = 0;
                dfs(matrix, direction, i, j, cache, currentAns);
                cache[i][j] = currentAns.bestAns;
                max = Math.max(max, cache[i][j]);
            }
        }
        return max;
    }

    private boolean isValidIndex(int[][] matrix, int m, int n) {
        if (m < 0 || n < 0) {
            return false;
        }
        return m < matrix.length && n < matrix[m].length;
    }

    private void dfs(int[][] matrix, int[][] direction, int m, int n, int[][] cache, Ans ans) {
        for (int[] dir : direction) {
            if (cache[m][n] != 0) {
                ans.bestAns = Math.max(ans.curAns + cache[m][n], ans.bestAns);
                return;
            }
            ans.curAns += 1;
            if (!isValidIndex(matrix, m + dir[0], n + dir[1]) || matrix[m + dir[0]][n + dir[1]] <= matrix[m][n]) {
                // 其中的一个答案， 并不是最终答案
                ans.bestAns = Math.max(ans.curAns, ans.bestAns);
                ans.curAns -= 1;
                continue;
            }
            if (matrix[m + dir[0]][n + dir[1]] > matrix[m][n]) {
                dfs(matrix, direction, m + dir[0], n + dir[1], cache, ans);
            }
            ans.curAns -= 1;
        }
    }

}
