class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int nextNum = nums[0] + 1;
        for(int i = 1; i < nums.length; i++){
            int max = Math.max(nextNum,nums[i]);
            ans += (max-nums[i]);
            nextNum = max + 1;
        }
        return ans;
    }
}