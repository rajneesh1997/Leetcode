class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> set;
        for(auto x:nums){
            if(set.count(x)) return true;
            set.insert(x);
        }
        return false;
    }
};