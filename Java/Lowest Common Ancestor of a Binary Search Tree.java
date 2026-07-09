/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(q.val<p.val){
            solve(root,q,p);
        }
        else{
            solve(root,p,q);
        }
        return ans;
    }
    
    
    void solve(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return;
        }

        if(root == p || root == q){
             ans = root;
            return;
            
        }
        if(root.val<p.val){
            solve(root.right,p,q);
        }
        else if(root.val>q.val){
            solve(root.left,p,q);
        }
        else if(p.val<root.val && root.val<q.val ){
            ans = root;
            return ;
        }
    }
}