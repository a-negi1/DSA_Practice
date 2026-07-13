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
    TreeNode p1first = null;
    TreeNode p1second = null;
    TreeNode p2first = null;
    TreeNode p2second = null;
    int wrong = 0;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        solve(root);
        int val1 =0 ;
        int val2 =0;
        if(wrong == 1){
            val1 = p1first.val;
            val2 = p1second.val; 
        }
        else{
            val1 = p1first.val;
            val2 = p2second.val;
        }

        swap(root,val1,val2);
    }

    void solve(TreeNode root){
        if(root == null){
            return;
        }
        

        solve(root.left);
        if(prev == null){
            prev = root;
        }
        else{
            if(root.val < prev.val){
                if(wrong == 0){
                    p1first = prev;
                p1second = root;
                wrong++;
                }
                
            
            else{
                p2first = prev;
                p2second = root;
                wrong++;
            }
            
          }
        }
        prev = root;
        solve(root.right);
    }


    void swap(TreeNode root,int val1,int val2){
        if(root==null){
            return ;
        }

        if(root.val == val1){
            root.val = val2;
        }
        else if(root.val == val2){
            root.val = val1;
        }

        swap(root.left,val1,val2);
        swap(root.right,val1,val2);
    }
}