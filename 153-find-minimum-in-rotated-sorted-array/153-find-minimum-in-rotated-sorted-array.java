class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        if(nums[0] < nums[n-1])
            return nums[0];
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            if(nums[mid] < nums[mid-1])
                return nums[mid];
            
            if(nums[0] < nums[mid])
                left = mid+1;
            else
                right = mid-1;
        }
        return 0;
    }
}