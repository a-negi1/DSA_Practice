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
    public int sumNumbers(TreeNode root) {
        return solve(root,0);
    }

    int solve(TreeNode root,int sum){
        int res =0;
        
        if(root == null){
            return 0;
        }
        sum = sum*10 + root.val;

        if(root.right == null && root.left == null){
            return res+=sum;
        }
        else{
            res+=solve(root.left,sum);
            res+=solve(root.right,sum);

        }
        return res;
    }
}