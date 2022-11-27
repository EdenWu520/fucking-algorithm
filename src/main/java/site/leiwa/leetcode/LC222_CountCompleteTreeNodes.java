package site.leiwa.leetcode;

/**
 * @desc: todo
 *
 * @see <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">完全二叉树的节点个数</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/8
 */
public class LC222_CountCompleteTreeNodes {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
