class Solution {
    static int sumOfDigits(int n) {
        if(n==0){
            return 0;
        }
        
        int d = n %10;
        
        int f = n /10;
        
        int ans = sumOfDigits(f); 
        
        return d + ans;
        
    }
    
    
}
