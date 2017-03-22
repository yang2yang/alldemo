package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/22日
*/
public class LeetCode235 {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val){
            return root;
        }

        if((root.val > p.val && root.val < q.val)||(root.val < p.val && root.val > q.val)){
            return root;
        }

        if(root.val > p.val && root.val > q.val ){
            return lowestCommonAncestor(root.left,p,q);
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //使用乘法来简化判断，还有一点是最好使用if,elseif,else把所有的条件都包括进去
        if((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        }else if(root.val > p.val){
            return lowestCommonAncestor2(root.right,p,q);
        }else{
            return lowestCommonAncestor2(root.left,p,q);
        }
    }

}
