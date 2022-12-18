package site.leiwa.leetcode.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/kplEvH/">自行车炫技赛场</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/18
 */
public class LC_Lcp45_BicycleYard {

    public static void main(String[] args) {

        // int[] position = new int[] {1, 1};
        int[] position = new int[] {0, 1};
        //
        // int[][] terrain = new int[][] {{48, 39, 83, 65, 33, 18, 50, 5, 14}, {46, 95, 62, 1, 67, 84, 71, 76, 49},
        // {6, 73, 12, 51, 54, 5, 90, 83, 10}, {1, 8, 42, 63, 91, 3, 5, 63, 66}, {56, 62, 32, 25, 5, 39, 9, 82, 1},
        // {62, 4, 51, 94, 3, 78, 0, 28, 84}, {89, 40, 35, 54, 11, 28, 54, 29, 23}, {2, 22, 55, 99, 9, 48, 27, 71, 2}};
        //
        // int[][] obstacle = new int[][] {{21, 46, 15, 28, 49, 39, 12, 12, 1}, {39, 10, 23, 38, 14, 41, 40, 1, 6},
        // {1, 12, 27, 27, 8, 28, 0, 45, 26}, {29, 53, 37, 33, 18, 1, 17, 40, 1}, {31, 18, 48, 40, 30, 29, 48, 37, 11},
        // {27, 26, 37, 42, 11, 30, 3, 31, 24}, {44, 25, 10, 41, 28, 19, 8, 15, 34},
        // {46, 36, 47, 4, 5, 37, 40, 37, 13}};

        // int[][] terrain = new int[][] {{48, 39, 83}, {46, 95, 62}, {6, 73, 12}, {1, 8, 42}};
        //
        // int[][] obstacle = new int[][] {{21, 46, 15}, {39, 10, 23}, {1, 12, 27,}, {29, 53, 37}};

        // int[][] terrain = new int[][] {{5, 0}, {0, 6}};
        // int[][] obstacle = new int[][] {{0, 6}, {7, 0}};

        int[][] terrain = {{63, 91, 53, 6, 70, 29, 1, 86, 31}, {0, 42, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 74, 77, 94, 8}, {55, 57, 59, 0, 0, 0, 11, 33, 23}, {58, 27, 51, 0, 0, 56, 10, 24, 7},
            {82, 49, 74, 0, 0, 79, 96, 68, 25}, {72, 51, 67, 0, 58, 59, 81, 52, 64},
            {95, 30, 35, 0, 45, 79, 71, 15, 74}};

        int[][] obstacle = {{21, 7, 31, 16, 33, 39, 25, 12, 4}, {0, 42, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 19, 14, 43, 30}, {50, 8, 37, 0, 0, 0, 44, 33, 17}, {5, 12, 29, 0, 0, 30, 2, 33, 40},
            {40, 18, 14, 0, 0, 24, 15, 6, 19}, {10, 3, 40, 0, 39, 38, 16, 44, 48}, {48, 27, 26, 0, 42, 13, 9, 25, 31}};

        System.out.println(Arrays.deepToString(new LC_Lcp45_BicycleYard().bicycleYard(position, terrain, obstacle)));
    }

    static class Place {
        int terrain;
        int obstacle;
        int speed;

    }

    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        int n = terrain.length;
        int m = terrain[0].length;
        // 初始化场地
        Place[][] matrix = new Place[n][m];
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Place place = new Place();
                place.terrain = terrain[i][j];
                place.obstacle = obstacle[i][j];
                matrix[i][j] = place;
            }
        }
        // 初始化当前位置的默认速度
        matrix[position[0]][position[1]].speed = 1;

        // 初始化方向
        int[][] direction = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Set<List<Integer>> ans = new HashSet<>(100);
        HashMap<Place, Set<Integer>> visited = new HashMap<>();

        dfs(matrix, direction, visited, position[0], position[1], position, ans);

        int[][] ints =
            ans.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        Arrays.sort(ints, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        return ints;
    }

    private void dfs(Place[][] matrix, int[][] direction, HashMap<Place, Set<Integer>> visited, int x, int y,
        int[] position, Set<List<Integer>> ans) {

        if (matrix[x][y].speed <= 0) {
            return;
        }

        if (matrix[x][y].speed == 1 && !(x == position[0] && y == position[1])) { // 记录答案
            ans.add(Arrays.asList(x, y));
        }

        if (visited.containsKey(matrix[x][y])) {
            if (visited.get(matrix[x][y]).contains(matrix[x][y].speed)) {
                return;
            }
            visited.get(matrix[x][y]).add(matrix[x][y].speed);
        }
        visited.put(matrix[x][y], new HashSet<>(Arrays.asList(matrix[x][y].speed)));

        for (int[] dirs : direction) {
            int nextX = x + dirs[0];
            int nextY = y + dirs[1];

            if (!isValid(matrix, nextX, nextY)) {
                continue;
            }
            // 计算速度并校验
            // s = (x1, y1) -> (x2, y2) = x1.terrain - x2.terrain - x2.obstacle + x1.speed
            int i = matrix[x][y].terrain - matrix[nextX][nextY].terrain - matrix[nextX][nextY].obstacle
                + matrix[x][y].speed;
            matrix[nextX][nextY].speed += i;
            dfs(matrix, direction, visited, nextX, nextY, position, ans);
            matrix[nextX][nextY].speed -= i;
        }
    }

    // 校验到下一个位置是否合法
    private boolean isValid(Place[][] matrix, int nextX, int nextY) {
        // 校验位置
        return nextX >= 0 && nextY >= 0 && nextX < matrix.length && nextY < matrix[0].length;
    }

}
