package site.leiwa.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">二叉树的中序遍历</a>
 * @since 2022/11/7
 */
public class LC94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode.Builder().build();
        List<Integer> ans = new LC94_BinaryTreeInorderTraversal().inorderTraversal(root);
        System.out.println(ans);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
