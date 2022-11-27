package site.leiwa.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: todo
 *
 *
 * @see <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/">找树左下角的值</a>
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/8
 */
public class LC513_FindBottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode.Builder().build();
        System.out.println(new LC513_FindBottomLeftTreeValue().findBottomLeftValue(root));

    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            list.clear();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) {
                    continue;
                }
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
        return list.get(0);
    }


}
