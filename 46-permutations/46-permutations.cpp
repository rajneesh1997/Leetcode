class Solution {
public:
    void generate(vector<vector<int>>& output, vector<int>& v, unordered_map<int,int>& m, vector<int>& nums){
        if(v.size() == nums.size()){
            output.push_back(v);
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            if(!m[i]){
                m[i] = 1;
                v.push_back(nums[i]);
                generate(output,v,m,nums);
                v.pop_back();
                m[i] = 0 ;
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> output;
        vector<int> v;
        unordered_map<int,int> m;
        generate(output,v,m,nums);
        return output;
    }
};