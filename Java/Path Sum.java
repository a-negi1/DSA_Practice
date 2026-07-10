/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root,0,targetSum);
        }

    boolean solve(TreeNode root,int initialsum,int targetSum){
        boolean res =false;
        

        if(root == null){
            return false;
        }
        int sum = initialsum + root.val;
        if(root.left == null && root.right ==null){
            if( sum == targetSum){
                res = true;
            }
        }else{
            boolean leftPath =solve(root.left,sum,targetSum);
            boolean rightPath= solve(root.right,sum,targetSum);

            res = leftPath || rightPath;
            
        }
        return res;
    }
}