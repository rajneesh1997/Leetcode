class Solution {
    public int[] buildArray(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        int i = 0;
        for(int num:nums){
            ans[i++] = nums[num];
        }
        return ans;
    }
}