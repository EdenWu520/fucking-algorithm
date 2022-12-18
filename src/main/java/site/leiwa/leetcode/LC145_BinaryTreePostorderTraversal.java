package site.leiwa.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: todo
 *
 * @see <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">二叉树的后序遍历</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/7
 */
public class LC145_BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode.Builder().build();
        List<Integer> ans = new LC145_BinaryTreePostorderTraversal().postorderTraversal(root);
        List<Integer> ans1 = new LC145_BinaryTreePostorderTraversal().postorderTraversal1(root);
        System.out.println(ans);
        System.out.println(ans1);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    private void postorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                ans.add(node.val);
                stack.push(node);
                node = node.right;
            }
            TreeNode pop = stack.pop();
            node = pop.left;
        }
        Collections.reverse(ans);
        return ans;
    }
}
