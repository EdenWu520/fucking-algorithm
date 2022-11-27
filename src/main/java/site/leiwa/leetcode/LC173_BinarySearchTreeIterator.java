package site.leiwa.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.cn/problems/binary-search-tree-iterator/">二叉搜索树迭代器</a>
 */
public class LC173_BinarySearchTreeIterator {

    public static void main(String[] args) {


    }

    static class BSTIterator {
        private Deque<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode cur = stack.peek();
            TreeNode node = cur;
            if (node.right == null) {
                node = stack.pop();
                while (hasNext() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return cur.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }


    // 这种更香
    static class BSTIterator1 {
        private Deque<TreeNode> stack;

        public BSTIterator1(TreeNode root) {
            stack = new LinkedList<>();
            findMostLeft(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                findMostLeft(node.right);
            }
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void findMostLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
