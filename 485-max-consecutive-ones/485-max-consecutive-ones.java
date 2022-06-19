class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r = 0, n = nums.length, ans = 0;
        while(r <= (n-1)){
            if(nums[l] == 1){
                if(nums[r] == 1)
                    r++;
                else {
                    if(nums[r] == 0){
                        ans = Math.max(ans, r - l);
                        l = r;
                    }
                }
            } else {
                l++;
                r++;
            }
        }
        return Math.max(ans, r - l);
    }
}