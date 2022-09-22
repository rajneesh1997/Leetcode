class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            // int n = nums[mid];
            if(mid == 0){
                if(nums[mid] < nums[mid+1])
                    return nums[mid];
            }
            if(mid == n-1){
                if(nums[mid] < nums[mid-1])
                    return nums[mid];
            }
            if(mid > 0 && mid < n-1)
                if(nums[mid-1] > nums[mid] && nums[mid] < nums[mid+1])
                        return nums[mid];
            if(nums[0] <= nums[mid]){
                if(nums[n-1] < nums[mid])
                    left = mid + 1;
                else if(nums[n-1] > nums[mid])
                    right = mid - 1;
            }
            if(nums[0] > nums[mid]){
                if(nums[n-1] > nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
        }
        return 0;
    }
}