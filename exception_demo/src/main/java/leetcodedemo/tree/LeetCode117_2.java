package leetcodedemo.tree;

import leetcodedemo.LeetCode1;
import leetcodedemo.TreeLinkNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by jack-pc on 2017/5/12.
 */
//使用有空间复杂度的递归来进行解决
public class LeetCode117_2 {

    public static void main(String[] args) {
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);
        treeLinkNode.right = new TreeLinkNode(3);
        treeLinkNode.left.left = new TreeLinkNode(4);
        treeLinkNode.left.right = new TreeLinkNode(5);
        LeetCode117_2 leetCode117_2 = new LeetCode117_2();
        leetCode117_2.connect(treeLinkNode);
    }

    public void connect(TreeLinkNode root) {
        help(root);
    }

    private void help(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                TreeLinkNode treeLinkNode = root.next;
                while (treeLinkNode != null) {
                    if (treeLinkNode.left != null) {
                        root.left.next = treeLinkNode.left;
                        break;
                    }
                    if (treeLinkNode.right != null) {
                        root.left.next = treeLinkNode.right;
                        break;
                    }
                    treeLinkNode = treeLinkNode.next;
                }
            }

        }

        if (root.right != null) {
            TreeLinkNode treeLinkNode = root.next;
            while (treeLinkNode != null) {
                if (treeLinkNode.left != null) {
                    root.right.next = treeLinkNode.left;
                    break;
                }
                if (treeLinkNode.right != null) {
                    root.right.next = treeLinkNode.right;
                    break;
                }
                treeLinkNode = treeLinkNode.next;
            }
        }
        help(root.right);
        help(root.left);
    }
}
