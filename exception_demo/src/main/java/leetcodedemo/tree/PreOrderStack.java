package leetcodedemo.tree;

/**
 * Created by jack-pc on 2017/5/1.
 */

import leetcodedemo.TreeNode;

import java.util.Stack;

/**
 * 使用迭代的方法先序遍历树
 */
public class PreOrderStack {

    public static void main(String[] args) {

    }

    /**
     * 迭代前序遍历树
     *
     * @param root
     */
    public void preOrderStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }


    /**
     * 迭代中序遍历树
     *
     * @param root
     */
    public void inOrderStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    /**
     * 迭代后序遍历树
     *
     * @param root
     */
//    public void afterOrderStack(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        Map<TreeNode, Boolean> map = new HashMap<>();
//        while (!stack.isEmpty() || root != null) {
//            TreeNode temp = stack.peek();
//            if (temp.left != null && !map.containsKey(temp.left)) {
//                temp = temp.left;
//                while (temp != null) {
//                    if (map.containsKey(temp)) {
//                        break;
//                    } else {
//                        stack.push(temp)
//                    }
//                    temp = temp.left;
//                }
//                continue;
//            }
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//
//            root = root.right;
//        }
//    }
}
