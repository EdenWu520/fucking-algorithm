package site.leiwa.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/binary-tree-paths/">左叶子之和</a>
 * @since 2022/11/8
 */
public class LC404_SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode.Builder().build();
        int i = new LC404_SumOfLeftLeaves().sumOfLeftLeaves(root);


    }

    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        int ans = 0;
        for (Integer in : list) {
            ans += in;
        }
        return ans;
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
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans.add(root.left.val);
        }
        inorder(root.left, ans);
        inorder(root.right, ans);
    }

}
