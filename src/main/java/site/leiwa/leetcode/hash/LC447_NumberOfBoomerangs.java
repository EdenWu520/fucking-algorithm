package site.leiwa.leetcode.hash;

import java.util.HashMap;

/**
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/number-of-boomerangs/">回旋镖的数量</a>
 * @see <a href="https://www.bilibili.com/video/BV1c84y1c7EG">题解</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/17
 */
public class LC447_NumberOfBoomerangs {
    public static void main(String[] args) {

        System.out.println(new LC447_NumberOfBoomerangs().numberOfBoomerangs(new int[][] {{0, 0}, {1, 0}, {2, 0}}));

    }

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        // 计算当前点和其它点的距离，存储在map中
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            // 当前点
            int[] curPoint = points[i];

            for (int[] point : points) {
                // 忽略自己
                if (curPoint == point) {
                    continue;
                }
                int distance = getDistance(curPoint, point);
                if (distanceMap.containsKey(distance)) {
                    distanceMap.put(distance, distanceMap.get(distance) + 1);
                } else {
                    distanceMap.put(distance, 1);
                }
            }

            // 计算回旋镖的数量
            for (Integer value : distanceMap.values()) {
                if (value >= 2) {
                    ans += value * (value - 1);
                }
            }

            distanceMap.clear();
        }
        return ans;
    }

    private int getDistance(int[] pointX, int[] pointY) {
        int dx = pointX[0] - pointY[0];
        int dy = pointX[1] - pointY[1];
        return dx * dx + dy * dy;
    }
}
