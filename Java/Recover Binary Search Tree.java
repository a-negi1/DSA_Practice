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
    List <Integer> res = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        solve(root);
        int wrong=0;
        int wrong1first=0,wrong1second=0,wrong2first=0,wrong2second=0;

        for(int i=0;i<res.size()-1;i++){
            if(res.get(i)>res.get(i+1)){
                if(wrong == 0){
                    wrong1first=res.get(i);
                    wrong1second=res.get(i+1);
                    wrong++;
                }

                else{
                    wrong2first=res.get(i);
                    wrong2second=res.get(i+1);
                    wrong++;

            }
          }
        }
            int val1 = 0, val2 = 0;
            if(wrong == 1){
                val1 = wrong1first;
                val2 = wrong1second;
                
            }
            else{
                val1 = wrong1first;
                val2 = wrong2second;
                
            }
            
            
            swap(root,val1,val2);
        }
    

    void solve(TreeNode root){
        if(root == null){
            return ;
        }

        solve(root.left);
        res.add(root.val);
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