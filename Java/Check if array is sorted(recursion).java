class Solution {
    public boolean isSorted(int[] arr) {
        int n = arr.length-1;
        
        return solve(arr,0 ,n);
        
    }
    
    boolean solve(int arr[],int i,int n){
        if(i == n|| i == n-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return solve(arr,i+1,n);
    }
}