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

//optimal approach less space complexity

class Solution {
        Stack <TreeNode> asc = new Stack<>();
        Stack <TreeNode> dsc = new Stack<>();
        public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;

        }

        TreeNode t1 = root;

        while(t1 !=null){
            asc.push(t1);
            t1=t1.left;
        }

        TreeNode t2 = root;

        while(t2 !=null){
            dsc.push(t2);
            t2=t2.right;
        }

        TreeNode i =getsmall();
        TreeNode j = getbig();
        while(i !=null && j != null && i!=j && i.val<j.val){
            int sum = i.val + j.val;

            if(sum==k){
            return true;}
            if(sum>k){
                j=getbig();
                
            }
            else{
                i=getsmall();
            }
        }
    return false;


        
    }

    TreeNode getsmall(){
        TreeNode small = asc.pop();
        TreeNode rightchild = small.right;

        while(rightchild !=null){
            asc.push(rightchild);
            rightchild = rightchild.left;
        }
        return small;

    }

    TreeNode getbig(){
        TreeNode big = dsc.pop();
        TreeNode leftchild=big.left;

        while(leftchild != null){
            dsc.push(leftchild);
            leftchild = leftchild.right;
        }
        return big;
    }
    

}