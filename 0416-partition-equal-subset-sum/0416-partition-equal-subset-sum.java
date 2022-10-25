class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int ele : nums){
            total += ele;
        }
        if(total % 2 == 1)
            return false;
        int k = total / 2;
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if(nums[0] <= k)
            prev[nums[0]] = true;
        int n = nums.length;
        for(int ind = 1; ind < n; ind++){
            boolean[] curr = new boolean[k+1];
            // curr[0] = true;
            for(int tar = 1; tar < k+1; tar++){
                boolean notPick = prev[tar];
                boolean pick = false;
                if(nums[ind] <= tar){
                    pick = prev[tar-nums[ind]];
                }
                curr[tar] = pick || notPick;
            }
            prev = curr;
        }
        return prev[k];
    }
}