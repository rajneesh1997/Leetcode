class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        unordered_map<int,int> map;
        for(auto x:nums)
            map[x]++;
        int ans = 0;
        for(auto x:map){
            if(x.second > 1)
                ans += ((x.second) * (x.second-1)) / 2;
        }
        return ans;
    }
};