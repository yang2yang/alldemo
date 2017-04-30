package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/4/30.
 */
public class LeetCode449 {
    public static void main(String[] args) {
        LeetCode449 leetCode449 = new LeetCode449();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return help(root, "");
    }

    private String help(TreeNode root, String result) {
        if (root == null) {
            return result;
        } else {
            if (result.equals("")) {
                result += root.val;
            } else {
                result += "," + root.val;
            }
            result = help(root.left, result);
            result = help(root.right, result);
            return result;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] ss = data.split(",");
        TreeNode treeNode = new TreeNode(Integer.parseInt(ss[0]));
        for (int i = 1; i < ss.length; i++) {
            //treeNode是会发生改变的,传递进去的时候，那么String为什么不改变呢，String也是对象啊？
            // String是不可变对象，每一次改变都会生成一个新的对象，然后将引用给改变掉
            putput(treeNode, Integer.parseInt(ss[i]));
        }
        return treeNode;
    }

    private void putput(TreeNode treeNode, Integer baidu) {
        if (treeNode == null) {//对初始化的参数进行判断
            return;
        }
        if (treeNode.val > baidu) {
            if (treeNode.left != null) {
                putput(treeNode.left, baidu);
            } else {
                treeNode.left = new TreeNode(baidu);
            }
        } else {
            if (treeNode.right != null) {
                putput(treeNode.right, baidu);
            } else {
                treeNode.right = new TreeNode(baidu);
            }
        }
    }

}
