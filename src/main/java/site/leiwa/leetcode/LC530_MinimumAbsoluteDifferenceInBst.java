package site.leiwa.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/validate-binary-search-tree/">验证二叉搜索树</a>
 * @since 2022/11/9
 */
public class LC530_MinimumAbsoluteDifferenceInBst {
    static class Ans {
        int ans = Integer.MAX_VALUE;
    }


    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i) - ans.get(i - 1) < minValue) {
                minValue = ans.get(i) - ans.get(i - 1);
            }
        }
        return minValue;
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
