class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==1) return nums[0];
        if(nums.size()==2) return max(nums[0],nums[1]);
        // if(nums.size()==3) return max(nums[0]+nums[2],nums[1]);
        nums[1]=max(nums[1],nums[0]);
        for(int i=2;i<nums.size();i++){
            nums[i] = max(nums[i]+nums[i-2],nums[i-1]);
        }
        int n = nums.size();
        return max(nums[n-1],nums[n-2]);
    }
};