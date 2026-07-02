class pair{
    int value = 0;
    int row =0;
    int column = 0;
    pair(int a,int b,int c){
        this.value = a;
        this.row = b;
        this.column = c;
    }
}

class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        ArrayList <Integer> res = new ArrayList<>();
        if(mat == null || mat.length == 0){
            return res;
        }
        PriorityQueue <pair> pq = new PriorityQueue<>((a,b)-> a.value - b.value);
        
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n;i++){
            if(mat[i].length>0)
            pq.add(new pair(mat[i][0],i,0));
        }
        
        while(!pq.isEmpty()){
           
           pair i = pq.poll();
           
            res.add(i.value);
            int row = i.row;
            int col = i.column;
            
            if(col +1 < mat[row].length ){
            pq.add(new pair(mat[row][col+1],row,col+1));}
        }
        return res;
    }
}