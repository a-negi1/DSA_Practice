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
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums,0,nums.length-1);
    }

    TreeNode solve(int[]nums,int low,int high){
        if(low>high){
            return null;
        }
        int idx = low + (high - low) / 2;
        TreeNode t = new TreeNode(nums[idx]);

        t.left = solve(nums,low,idx-1);
        t.right = solve(nums,idx+1,high);

        return t;

    }
}