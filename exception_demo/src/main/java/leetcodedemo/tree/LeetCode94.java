package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
**  author:jack 2017年04月2017/4/5日
*/
public class LeetCode94 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

}
