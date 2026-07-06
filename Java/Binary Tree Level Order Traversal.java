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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List <List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue <TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        while(!pq.isEmpty()){
            int level = pq.size();
            ArrayList <Integer> temp = new ArrayList<>();
            
            while(level-->0){
                TreeNode t = pq.poll();
                
                temp.add(t.val);
                if( t.left != null){
                    pq.offer(t.left);
                }

                if (t.right != null ){
                    pq.offer(t.right);
                }
               
            }
             res.add(temp);
        }
        return res;
    }

   
}