class Solution {
    public int maxArea(int[] height) {
        int n = height.length - 1;
        int max = 0;
        int i = 0;
        int j = n;
        while (i < j) {
            int min = Math.min(height[i], height[j]) * (j);
            max = Math.max(max, min);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}