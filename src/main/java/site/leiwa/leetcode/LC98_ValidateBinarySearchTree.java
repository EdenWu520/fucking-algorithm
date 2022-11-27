package site.leiwa.leetcode;

/**
 * @desc: todo
 *
 * @see <a href="https://leetcode.cn/problems/validate-binary-search-tree/">验证二叉搜索树</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/9
 */
public class LC98_ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isValidBST(TreeNode root, long maxValue, long minValue) {
        if (root == null) {
            return true;
        }

        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }
        return isValidBST(root.left, root.val, minValue) && isValidBST(root.right, maxValue, root.val);
    }
}
