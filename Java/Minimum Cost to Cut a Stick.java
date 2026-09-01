//recursive
class Solution {
    public int minCost(int n, int[] cuts) {
        int len=cuts.length;
        ArrayList <Integer> a  = new ArrayList<>();
        a.add(0);
        for(int i=0;i<len;i++){
            a.add(cuts[i]);
        }
        
        a.add(n);
        Collections.sort(a);
        return solve(a,1,a.size()-2);
    }

    int solve(ArrayList <Integer>b,int i,int j){

        if(i>j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int curr = b.get(j+1)  - b.get(i-1) + solve(b,i,k-1) + solve(b,k+1,j) ;
             min = Math.min(curr,min);
            
        }
        return min;
    }


}

