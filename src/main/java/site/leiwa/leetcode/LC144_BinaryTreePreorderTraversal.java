package site.leiwa.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: <a href="https://blog.csdn.net/My_Jobs/article/details/43451187">构树帖子<a/>
 * @see <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">二叉树的前序遍历</a>
 * @since 2022/11/6
 */
public class LC144_BinaryTreePreorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode.Builder().build();
        List<Integer> ans = new LC144_BinaryTreePreorderTraversal().preorderTraversal(root);
        System.out.println(ans);
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
