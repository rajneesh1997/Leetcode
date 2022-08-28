class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
        int n = nums.length;
        int left = 0, right = n;
        while(left <= right){
            int mid = left + ((right-left)/2);
            // System.out.println(mid);
            if(mid > 0 && mid < n-1){
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                    return mid;
                else {
                    if(nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1])
                        left = mid + 1;
                    else 
                        right = mid - 1;
                }
            } else {
                if(mid == 0){
                    return nums[mid] < nums[mid+1] ? 1 : 0;
                } else if(mid == n-1){
                    return nums[mid] < nums[mid-1] ? n-2 : n - 1;
                }
            }
        }
        if(nums[0] > nums[n-1])
            return 0;
        return n-1;
    }
}