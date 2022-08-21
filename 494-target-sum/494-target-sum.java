class Solution {
    int s = 0;
    public int func(int index, int target, int sum, int[] nums,int[][] dp){
        if(index == -1){
            if(target == sum)
                return 1;
            else
                return 0;
        }
        if(dp[index][sum+s] != -1) return dp[index][sum+s];
        int addNum = func(index-1, target, sum + nums[index], nums, dp);
        int subNum = func(index-1, target, sum - nums[index], nums, dp);
        return dp[index][sum+s] = addNum + subNum;
    }
    public int findTargetSumWays(int[] nums, int target) {
        for(int num : nums){
            s += num;
        }
        int[][] dp = new int[nums.length][2 * s + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return func(nums.length-1, target, 0, nums, dp);
    }
}