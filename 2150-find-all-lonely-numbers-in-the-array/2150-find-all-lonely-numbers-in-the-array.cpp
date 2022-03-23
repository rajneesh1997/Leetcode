class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        unordered_map<int,int> map;
        for(auto x:nums)
            map[x]++;
        vector<int> ans;
        for(auto x:nums){
            int crr = x;
            if(map[crr]>1) continue;
            if(map[crr-1] == 0 && map[crr+1] == 0)
                ans.push_back(crr);
        }
        return ans;
    }
};