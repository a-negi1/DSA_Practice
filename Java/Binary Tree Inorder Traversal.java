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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList <Integer> ar = new ArrayList<>();
        solve(root,ar);
        return ar;

    }

    void solve(TreeNode node,List<Integer> result){
        if(node == null){
            return;
        }
        solve(node.left,result);
        result.add(node.val);
        solve(node.right,result);
    }

}