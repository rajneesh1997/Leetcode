class Solution {
    public int func(int index, int target, int sum, int[] nums){
        if(index == -1){
            if(target == sum)
                return 1;
            else
                return 0;
        }
        int addNum = func(index-1, target, sum + nums[index], nums);
        int subNum = func(index-1, target, sum - nums[index], nums);
        return addNum + subNum;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return func(nums.length-1, target, 0, nums);
    }
}