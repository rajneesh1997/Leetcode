class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() == 1) return 1;
        if(nums.size() == 2){
            if(nums[0] == nums[1]){
                return 1;
            }
            else{
                return 2;
            }
        }
        int i = 0; int j = i+1;
        unordered_set<int> set;
        set.insert(nums[i]);
        while(j < nums.size()){
            if(set.count(nums[j]))
                j++;
            else{
                swap(nums[i+1],nums[j]);
                set.insert(nums[i+1]);
                i++;
            }
        }
        return set.size();
    }
};