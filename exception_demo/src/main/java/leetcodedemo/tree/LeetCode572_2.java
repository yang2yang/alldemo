package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.Stack;

/**
 * Created by jack-pc on 2017/5/8.
 */
public class LeetCode572_2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);

        LeetCode572_2 leetCode572 = new LeetCode572_2();
        System.out.println(leetCode572.isSubtree(treeNode, t));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String spreorder = generatepreorderString(s);
        String tpreorder = generatepreorderString(t);

        return spreorder.contains(tpreorder) ;
    }
    public String generatepreorderString(TreeNode s){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stacktree = new Stack();
        stacktree.push(s);
        while(!stacktree.isEmpty()){
            TreeNode popelem = stacktree.pop();
            if(popelem==null)
                sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
            else
                sb.append(","+popelem.val);
            if(popelem!=null){
                stacktree.push(popelem.right);
                stacktree.push(popelem.left);
            }
        }
        return sb.toString();
    }
}
