package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack-pc on 2017/5/15.
 */
public class LeetCode113 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        LeetCode113 leetCode113 = new LeetCode113();
        leetCode113.pathSum(treeNode,2);
        System.out.println(1);
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        help(root, new ArrayList<Integer>(), sum);
        return result;
    }

    private void help(TreeNode root, List<Integer> list, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            List listOther = new ArrayList(list);
            result.add(listOther);
        }
        help(root.left, list, sum - root.val);
        help(root.right, list, sum - root.val);
        list.remove(list.get(list.size() - 1));
    }
}
