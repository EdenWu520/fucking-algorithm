package site.leiwa.leetcode;


/**
 * <a href="https://blog.csdn.net/My_Jobs/article/details/43451187">构树帖子<a/>
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static class Builder {

        public TreeNode build() {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(8);
            root.right = new TreeNode(3);
            root.right.right = new TreeNode(6);
            return root;
        }
    }

}
