package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jack-pc on 2017/5/21.
 */
public class LeetCode297 {
    public static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return help(root);
    }

    private String help(TreeNode root) {
        if (root == null) {
            return ",null";
        }
        return "," + String.valueOf(root.val) + help(root.left) + help(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return help2(nodes);
    }

    private TreeNode help2(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("null")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = help2(nodes);
            node.right = help2(nodes);
            return node;
        }
    }
}
