package site.leiwa.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/3sum/">三数之和</a>
 */
// 模拟，时间O(n^3)
public class LC15_3sum {
    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        System.out.println(new LC15_3sum().threeSum(ints));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < sortedNums.length; i++) {
            if (sortedNums[i] > 0) {
                break; // 排序去重后如果第一个数大于0，直接结束循环
            }
            // 把第一个数标记为 target，在数组里面去找到另外的两个数，使其 -target = num1 + num2
            int target = -sortedNums[i];
            // 如果匹配的数无法和target去匹配，下一次即可直接忽略
            for (int j = i + 1, k = nums.length - 1; j < k && j < nums.length && k > 0; ) {
                if (sortedNums[j] + sortedNums[k] > target) {
                    k--;
                } else if (sortedNums[j] + sortedNums[k] < target) {
                    j++;
                } else {
                    ArrayList<Integer> subAns = new ArrayList<>();
                    subAns.add(sortedNums[i]);
                    subAns.add(sortedNums[j]);
                    subAns.add(sortedNums[k]);
                    ans.add(subAns);
                    while (i < nums.length - 1 && sortedNums[i] == sortedNums[i + 1]) {
                        i++;
                    }
                    while (j < nums.length - 1 && sortedNums[j] == sortedNums[j + 1]) {
                        j++;
                    }
                    while (k > 0 && sortedNums[k] == sortedNums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
}
