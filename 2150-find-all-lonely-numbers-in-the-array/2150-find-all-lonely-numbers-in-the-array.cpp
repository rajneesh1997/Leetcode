class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        vector<int> v(1000003);
        for(auto x:nums){
            v[x+1]++;
        }
        vector<int> ans;
        for(auto x:nums){
            if(v[x] == 0 && v[x+1] == 1 && v[x+2] == 0)
                ans.push_back(x);
        }
        return ans;
    }
};