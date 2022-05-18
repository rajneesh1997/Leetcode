class Solution {
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            nums[i] += nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
            i++; j--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
}