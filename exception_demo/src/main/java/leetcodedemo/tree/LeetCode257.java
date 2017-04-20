package leetcodedemo.tree;

import com.sun.org.apache.xpath.internal.FoundIndex;
import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * *  author:jack 2017年04月2017/4/20日
 */
public class LeetCode257 {

    public static void main(String[] args) {

    }

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
//            help(root, String.valueOf(root.val));
            help2(root, String.valueOf(root.val));
        }
        return res;
    }

    private void help(TreeNode n, String path) {
        if (n.left == null && n.right == null) {
            res.add(path);
        }
        if (n.left != null) {
            help(n.left, path + "->" + n.left.val);
        }
        if (n.right != null) {
            help(n.right, path + "->" + n.right.val);
        }
    }


    private void help2(TreeNode n, String path) {
        if (path.equals("")) {
            path = String.valueOf(n.val);
        } else {
            path = path + "->" + n.val;
        }
        if (n.left == null && n.right == null) {
            res.add(path);
        }
        if (n.left != null) {
            help2(n.left, path);
        }
        if (n.right != null) {
            help2(n.right, path);
        }
    }
}
