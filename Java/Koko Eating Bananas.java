class Solution {
    private long calculateHours(int[] piles, int speed) {
        long totalHours=0;
        
        for (int i = 0; i < piles.length; i++) {
            totalHours+=(piles[i] / speed);
            

            if (piles[i] % speed != 0) {
                totalHours++;
            }
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int i = 0; i < piles.length; i++) {
            maxPile=Math.max(maxPile, piles[i]);
        }

        int low =1;
        int high =maxPile;
        int res =-1;

        while (low<=high) {
            int guess = low + (high - low) / 2; 
            
            long hours=calculateHours(piles, guess);
            
            if (hours>h) {
                low =guess +1;
            } else {
                res =guess;
                high =guess - 1;
            }
        }
        
        return res;
    }
}