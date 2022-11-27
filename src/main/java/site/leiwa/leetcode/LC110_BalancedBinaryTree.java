package site.leiwa.leetcode;


/**
 * @see <a href="https://leetcode.cn/problems/balanced-binary-tree/">平衡二叉树</a>
 */
public class LC110_BalancedBinaryTree {

    public static void main(String[] args) {


    }

    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        helper(root);
        return balanced;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = 1 + helper(root.left);
        int r = 1 + helper(root.right);
        if (Math.abs(l - r) > 1) {
            balanced = false;
        }
        return Math.max(l, r);
    }

}
