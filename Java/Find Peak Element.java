class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int res = -1;
        while(low<=high){
            int guess = low + (high - low) /2;

            if(guess < nums.length - 1 && nums[guess]<nums[guess+1]){
                low = guess + 1;
            }else{
                res = guess;
                high=guess-1;

            }
        }
        return res;
    }
}