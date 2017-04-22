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
        //其实这里是一个剪枝的行为,当有一部分子树满足条件的时候，就剪枝
        if(!flag){
            return -1;
        }
        if(tree.right != null){
            rightDeep = help(tree.right,deep+1);
        }
        if(!flag){
            return -1;
        }
        //如果flag还是false的话，在判断左右子树是否相差大于1，如果是那么就将flag置为false
        if(flag && Math.abs(leftDeep - rightDeep) > 1){
            flag = false;
        }

        return Math.max(leftDeep,rightDeep);
    }

}
