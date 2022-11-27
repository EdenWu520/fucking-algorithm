package site.leiwa.leetcode;

import java.util.Arrays;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: todo
 * @see <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">从中序与后序遍历序列构造二叉树</a>
 * @since 2022/11/8
 */
public class LC106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode tree = new LC106_ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(inorder, postorder);
        System.out.println(new LC94_BinaryTreeInorderTraversal().inorderTraversal(tree));


        // [3,9,20,null,null,15,7]
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int index = findTargetOfIndex(inorder, postorder[postorder.length - 1]);

        if (index == -1) return null;

        int[] rootLeft = Arrays.copyOfRange(inorder, 0, index);

        int[] rootRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        root.left = buildTree(rootLeft, Arrays.copyOfRange(postorder, 0, rootLeft.length));

        root.right = buildTree(rootRight, Arrays.copyOfRange(postorder, rootLeft.length, postorder.length - 1));
        return root;
    }

    private int findTargetOfIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;
            }
        }
        return -1;
    }


}
