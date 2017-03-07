package leetcodedemo;


/**
 * *  author:jack 2017年03月2017/3/3日
 */
public class LeetCode101 {

    public StringBuilder beforeOrder = new StringBuilder();

    public StringBuilder AfterOrder = new StringBuilder();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(2);

        LeetCode101 leetCode101 = new LeetCode101();
        System.out.println(leetCode101.isSymmetric2(treeNode));
    }


    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            //前序遍历左子树和后序遍历右子树，判断每一个返回的结果是不是一致
            return isSymmetricPanDuan(root.left, root.right);
        }
    }

    public boolean isSymmetricPanDuan(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {
            return isSymmetricPanDuan(root1.left, root2.right) && (root1.val == root2.val) && isSymmetricPanDuan(root1.right, root2.left);
        } else {
            return false;
        }
    }


    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            getBeforeOrder(root.left);
            getAfterOrder(root.right);
            System.out.println(beforeOrder.toString());
            System.out.println(AfterOrder.toString());
            if (beforeOrder.toString().equals(AfterOrder.toString())) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void getBeforeOrder(TreeNode root) {
        if (root == null) {
            beforeOrder.append("a");
        } else {
            getBeforeOrder(root.left);
            beforeOrder.append(root.val);
            getBeforeOrder(root.right);
        }
    }

    public void getAfterOrder(TreeNode root) {
        if (root == null) {
            AfterOrder.append("a");
        } else {
            getAfterOrder(root.right);
            AfterOrder.append(root.val);
            getAfterOrder(root.left);
        }
    }
}
