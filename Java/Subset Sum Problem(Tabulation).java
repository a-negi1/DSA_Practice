class Solution {

    static boolean isSubsetSum(int arr[], int sum) {

        int n=arr.length;

        boolean dp[][] = new boolean[n+1][sum+1];

       

        for(int i=0;i<sum;i++){

            dp[n][i] = false;

        }



        dp[n][0] = true;

        for(int i=n-1;i>=0;i--){

            for(int s=0 ; s<=sum;s++ ){

                if(arr[i]>s){

                     dp[i][s]=dp[i+1][s];

                }



                else{

                    dp[i][s] = dp[i+1][s-arr[i]] || dp[i+1][s];

                }

            }

        }

        return dp[0][sum];

    }

   

   

} 

