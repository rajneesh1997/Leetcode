class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        auto s1 = unordered_set<int>(nums1.begin(),nums1.end());
        auto s2 = unordered_set<int>(nums2.begin(),nums2.end());
        for(auto x:nums1){
            if(s2.count(x))
                s2.erase(x);
        }
        for(auto x:nums2){
            if(s1.count(x))
                s1.erase(x);
        }
        auto v1 = vector<int>(s1.begin(),s1.end());
        auto v2 = vector<int>(s2.begin(),s2.end());
        vector<vector<int>> ans;
        ans.push_back(v1);
        ans.push_back(v2);
        return ans;
    }
};