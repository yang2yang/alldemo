package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/23日
*/
public class LeetCode226 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }else{
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
