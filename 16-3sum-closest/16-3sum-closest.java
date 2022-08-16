class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int lo = i+1;
            int hi = nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(Math.abs(target-sum) < Math.abs(diff)){
                    diff = target - sum;
                }
                if(sum < target)
                    lo++;
                else
                    hi--;
                if(diff == 0)
                    return target;
            }
        }
        // if(diff == Integer.MAX_VALUE)
        //     diff = 0;
        return target - diff;
    }
}