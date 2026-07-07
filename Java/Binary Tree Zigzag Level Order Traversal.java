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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue <TreeNode> pq = new LinkedList<>();
        boolean leftToright = true;
        pq.offer(root);

        while(!pq.isEmpty()){
            int size= pq.size();
            LinkedList<Integer> temp = new LinkedList<>();
            
            while(size-->0){
                TreeNode p = pq.poll();
                

                if(leftToright){
                    temp.addLast(p.val);
                    
                }else{
                    temp.addFirst(p.val);
                }
                
                if(p.left!=null){
                    pq.offer(p.left);
                }
                if(p.right!=null){
                    pq.offer(p.right);
                }
                
            }
            res.add(temp);
            leftToright = !leftToright;
        }
        return res;
    }
}