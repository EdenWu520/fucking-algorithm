package site.leiwa.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: todo
 *
 * @see <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">二叉树的最小深度</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/8
 */
public class LC111_MinimumDepthOfBinaryTree {


    public static void main(String[] args) {


    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minLevel = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    return minLevel;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            minLevel += 1;
        }
        return minLevel;
    }

}
