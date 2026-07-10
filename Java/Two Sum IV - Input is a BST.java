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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList <Integer> ar = new ArrayList<>();
        solve(root,ar);
        int i=0;
        int j=ar.size()-1;
        
        while(i<j){
            int currentSum = ar.get(i) + ar.get(j);
            if(currentSum==k){
                return true;
            }
            if (currentSum<k){
                i++;
            }
            else{
                j--;
            }

        }
        return false;
    }

    

    void solve(TreeNode root,ArrayList<Integer>ar){
        if(root == null){
            return ;
        }

        solve(root.left,ar);
        ar.add(root.val);

        solve(root.right,ar);
        
    
    }

}