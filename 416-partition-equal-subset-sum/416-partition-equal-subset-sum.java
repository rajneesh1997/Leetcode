class Solution {
    public int subsetSum(int ind, int target, int[] nums, int[][] dp){
        if(target == 0) return 1;
        if(ind == 0) return nums[0] == target ? 1 : 0;
        if(dp[ind][target] != -1) return dp[ind][target];
        int notTake = subsetSum(ind-1,target,nums,dp);
        int take = 0;
        if(target >= nums[ind])
            take = subsetSum(ind-1, target-nums[ind], nums, dp);
        return dp[ind][target] = take | notTake;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int n : nums){
            totalSum += n;
        }
        if(totalSum % 2 != 0)
            return false;
        int target = totalSum / 2;
        int[][] dp = new int[nums.length][target+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return subsetSum(nums.length-1,target,nums, dp) == 1;
    }
}