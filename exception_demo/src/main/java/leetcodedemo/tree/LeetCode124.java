package leetcodedemo.tree;

import leetcodedemo.TreeNode;

/**
 * Created by jack-pc on 2017/5/26.
 */
public class LeetCode124 {
    public static void main(String[] args) {

    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        maxSum(root);

        return max;
    }

    public int maxSum(TreeNode root) {
        if (root == null) return 0;

        int leftVal = maxSum(root.left);    //递归求左支路的最大路径和
        int rightVal = maxSum(root.right);  //递归求右支路的最大路径和

        //如果当前局部解（root或left+root或root+right或left+root+right）是最有解，更新最终结果
        int curMax = root.val;
        if (leftVal > 0) {
            curMax += leftVal;
        }
        if (rightVal > 0) {
            curMax += rightVal;
        }
        if (curMax > max) {
            max = curMax;
        }

        //返回从叶子结点到root的最大路径和（root或left+root或root+right）
        return Math.max(root.val, Math.max(root.val + leftVal, root.val + rightVal));
    }
}
