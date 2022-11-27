package site.leiwa.leetcode;

import java.util.*;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/">二叉树的最近公共祖先</a>
 * @since 2022/11/9
 */
public class LC236_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode.Builder().build();
        TreeNode p = new TreeNode(8);
        TreeNode q = new TreeNode(3);
        System.out.println(new LC236_LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, p, q).val);


    }

    // 通过两个数组去寻找公共祖先 （数组分别存储到 p、q、的路线）
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> positionToP = new LinkedList<>();
        Deque<TreeNode> positionToQ = new LinkedList<>();
        findNodePosition(root, p, positionToP,new LinkedList<>(), false);
        findNodePosition(root, q, positionToQ,new LinkedList<>(), false);
        if (positionToQ.size() == 0) return positionToP.pop();
        if (positionToP.size() == 0) return positionToQ.pop();
        TreeNode ans = root;
        while (true) {
            while (positionToP.size() > positionToQ.size()) {
                positionToP.pop();
            }
            while (positionToP.size() < positionToQ.size()) {
                positionToQ.pop();
            }
            if (positionToP.peek() == positionToQ.peek()) {
                ans = positionToP.peek();
                break;
            } else {
                positionToP.pop();
                positionToQ.pop();
            }
        }
        return ans;
    }

    private void findNodePosition(TreeNode root, TreeNode node, Deque<TreeNode> list, Deque<TreeNode> path,  boolean finish) {
        if (root == null || finish) {
            return;
        }
        path.push(root);
        if (node.val == root.val) {
            finish = true;
            list.addAll(path);
        }
        findNodePosition(root.left, node,  list,path, finish);
        findNodePosition(root.right, node, list,path, finish);
        path.pop();
    }
}
