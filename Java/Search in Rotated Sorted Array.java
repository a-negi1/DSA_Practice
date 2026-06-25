class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int n = nums.length-1;
        int high = n;

        while(low<=high){
            int guess = low + (high - low)/2;

            if(nums[guess]<nums[n]){
                if(nums[guess]==target){
                    return guess;
                }
                else if(nums[guess]>target){
                    high = guess-1;
                }
                else{
                    if(nums[n] < target){
                        high = guess-1;
                    }
                    else{
                        low = guess +1;
                    }
                }
            }
            else{
                if(nums[guess]==target){
                    return guess;
                }
                else if(nums[guess]<target){
                    low = guess+1;
                }
                else{
                    if(nums[low]<=target){
                        high = guess-1;
                    }else{
                        low = guess + 1;
                    }

                }
            }

            
        }
    return -1;

    }
}