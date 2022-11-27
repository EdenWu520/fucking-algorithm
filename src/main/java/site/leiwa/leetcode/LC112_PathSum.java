package site.leiwa.leetcode;

/**
 * @desc: todo
 *
 * @see <a href="https://leetcode.cn/problems/path-sum/">路径总和</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/8
 */
public class LC112_PathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, 0, targetSum);
    }

    public boolean pathSum(TreeNode root, int patchSum, int target) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) { // 说明遍历到了叶子节点了
            // todo check path sum hasn't target
            patchSum += root.val;
            if (patchSum == target) {
                return true;
            }
            patchSum = 0;
        }
        patchSum += root.val; //

        return pathSum(root.left, patchSum, target) || pathSum(root.right, patchSum, target);
    }



}
