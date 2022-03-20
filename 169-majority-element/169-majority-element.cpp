class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size() / 2;
        unordered_map<int,int> map;
        for(auto x:nums){
            map[x]++;
            if(map[x] > n) return x;
        }
        return 0;
    }
};