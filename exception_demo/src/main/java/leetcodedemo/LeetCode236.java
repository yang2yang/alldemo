package leetcodedemo;

/**
 * *  author:jack 2017年03月2017/3/22日
 */
public class LeetCode236 {
    public static void main(String[] args) {
        LeetCode236 leetCode236 = new LeetCode236();
        TreeNode treeNode = new TreeNode(-1);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(-2);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(8);
        TreeNode resultNode = leetCode236.lowestCommonAncestor(treeNode,treeNode.left.left.left,treeNode.left.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        } else {//说明p,q肯定在root两侧或者说在某一侧
            boolean flagLeft = searchTreeNode(root.left, p);
            boolean flagRight = searchTreeNode(root.right, q);
            if ((flagLeft && flagRight) || (!flagLeft && !flagRight)) {//p在左，q在右或者p在右，q在左
                return root;
            } else if (flagLeft && !flagRight) {//p在左，q在左
                return lowestCommonAncestor(root.left, p, q);
            } else{//p在右，q在右
                return lowestCommonAncestor(root.right, p, q);
            }
        }
    }

    private boolean searchTreeNode(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        } else if (root == p) {
            return true;
        } else {
            return searchTreeNode(root.left, p) || searchTreeNode(root.right, p);
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        return null;
    }
}
