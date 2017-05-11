package leetcodedemo.tree;

import leetcodedemo.TreeLinkNode;

/**
 * Created by jack-pc on 2017/5/10.
 */
public class LeetCode117 {

    public static void main(String[] args) {
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);
        treeLinkNode.right = new TreeLinkNode(3);
        treeLinkNode.left.right =  new TreeLinkNode(4);
        treeLinkNode.right.right =  new TreeLinkNode(5);
        LeetCode117 leetCode117 = new LeetCode117();
        leetCode117.connect(treeLinkNode);
    }

    public void connect(TreeLinkNode root) {

        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
        }
    }
}
