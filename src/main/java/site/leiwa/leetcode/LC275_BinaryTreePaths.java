package site.leiwa.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/binary-tree-paths/">二叉树的所有路径</a>
 */
public class LC275_BinaryTreePaths {
    public static void main(String[] args) {

        //      1
        //    /   \
        //   2     3
        //    \
        //     5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        TreeNode root1 = new TreeNode(1);

        System.out.println(new LC275_BinaryTreePaths().binaryTreePaths(root));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, ans, "");
        return ans;
    }

    public void dfs(TreeNode root, List<String> ans, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(path + root.val);
        }
        path = path + root.val + "->";
        dfs(root.left, ans, path);
        dfs(root.right, ans, path);
    }
}
