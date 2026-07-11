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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> store = new ArrayList<>();
        return solve(root,0,store,targetSum);
    }

    List<List<Integer>> solve(TreeNode root,int sum,List<Integer> store,int targetSum){
        List<List<Integer>> res = new ArrayList<>() ;
        if(root ==null){
            return res;
        }
        
        sum = sum + root.val ;
        store.add(root.val);

        if(root.right == null && root.left == null){
            if(sum == targetSum){
                res.add(new ArrayList<>(store));
                
            }
            store.remove(store.size()-1);
            return res;
        }
        else{
            
            res.addAll(solve(root.left,sum,store,targetSum));
            res.addAll(solve(root.right,sum,store,targetSum));
            store.remove(store.size()-1);
            return res ;

        }
    }
}