package leetcodedemo.tree;

import leetcodedemo.TreeLinkNode;

/**
 * Created by jack-pc on 2017/5/6.
 */
public class LeetCode116 {
    public static void main(String[] args) {
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);
        treeLinkNode.right = new TreeLinkNode(3);
        LeetCode116 leetCode116 = new LeetCode116();
        leetCode116.connect(treeLinkNode);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            TreeLinkNode current = root;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }
                if (current.right != null) {
                    if (current.next != null) {
                        current.right.next = current.next.left;
                    }
                }
                current = current.next;
            }
            root = root.left;
        }
    }
}
