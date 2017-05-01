package leetcodedemo.tree;

import leetcodedemo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack-pc on 2017/5/1.
 */
public class BSTIterator {

    public static void main(String[] args) {

    }

    public List<Integer> list = new ArrayList<>();

    public Integer index = 0;
    
    public BSTIterator(TreeNode root) {
        help(root);
    }

    private void help(TreeNode root) {
        if(root == null){
            return;
        }else{
            help(root.left);
            list.add(root.val);
            help(root.right);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }
}
