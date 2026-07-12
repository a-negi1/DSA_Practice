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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;

        }

        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean nullfound = false;
        
        while(!q.isEmpty()){
           
            TreeNode p = q.poll();

            if(p==null){
                nullfound = true;
            }else{
                if(nullfound==true){
                    return false;
                    
                }
                q.offer(p.left);
                q.offer(p.right);
            }
        
            
        }
        return true;
    }
}