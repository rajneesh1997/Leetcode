class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            System.out.println(left + " " + mid + " " + right);
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[left]){
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return ans;
    }
}