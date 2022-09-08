class Solution {
    public long maximumSumScore(int[] nums) {
        int n = nums.length;
        long[] nums2 = new long[n];
        for(int i = 0; i < n; i++)
            nums2[i] = nums[i];
        int sum = 0;
        for(int i = 1; i < n; i++){
            nums2[i] += nums2[i-1];
        }
        
        long maxi = Math.max(nums[0], nums[n-1]);
        
        for(int i = 1; i < n; i++){
            maxi = Math.max(maxi, Math.max(nums2[i],nums2[n-1]-nums2[i-1]));
        }
        return maxi;
    }
}