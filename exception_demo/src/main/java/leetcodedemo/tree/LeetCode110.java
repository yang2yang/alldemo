package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
**  author:jack 2017年04月2017/4/21日
*/
public class LeetCode110 {

    public static void main(String[] args) {

    }

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if(root != null){
            help(root,0);
        }
        return flag;
    }

    private int help(TreeNode tree,int deep) {
        int leftDeep = deep;
        int rightDeep = deep;
        if(tree.left != null){
            leftDeep = help(tree.left,deep+1);
        }
        if(tree.right != null){
            rightDeep = help(tree.right,deep+1);
        }

        if(Math.abs(leftDeep - rightDeep) > 1){
            flag = false;
        }

        return Math.max(leftDeep,rightDeep);
    }

}
