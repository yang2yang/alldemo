package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/4/30.
 */
public class LeetCode449_2 {
    public static void main(String[] args) {
        LeetCode449_2 leetCode449_2 = new LeetCode449_2();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println(leetCode449_2.serialize(treeNode));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb); //preorder root - left - right
        return sb.toString();
    }

    public void serializeDFS(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        serializeDFS(root.left, sb);
        serializeDFS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String arr[] = data.split(",");
        return deserializeDFS(arr, 0, arr.length - 1);
    }

    public TreeNode deserializeDFS(String[] array, int left, int right) {
        if (left > right || left >= array.length) return null;
        TreeNode root = new TreeNode(Integer.parseInt(array[left]));
        int mid = getMid(array, left, right);
        root.left = deserializeDFS(array, left + 1, mid - 1);
        root.right = deserializeDFS(array, mid, right);
        return root;
    }

    public int getMid(String[] array, int left, int right) {
        int index = 0;
        System.out.println(left);
        int init = Integer.parseInt(array[left]);
        while (left <= right) {
            if (init < Integer.parseInt(array[left])) {
                break;
            } else left++;
        }
        return left;
    }
}
