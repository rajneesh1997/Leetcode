class Solution {
public:
    bool divideArray(vector<int>& nums) {
        unordered_map<int,int> map;
        for(auto x:nums)
            map[x]++;
        for(auto x:map){
            if(x.second % 2)
                return false;
        }
        return true;
    }
};