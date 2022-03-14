class Solution {
public:
    void generate(set<vector<int>>& output,int index, vector<int>& nums){
        if(nums.size() == index){
            output.insert(nums);
            return;
        }
        for(int i = index ; i < nums.size(); i++){
            swap(nums[i],nums[index]);
            generate(output,index+1,nums);
            swap(nums[i],nums[index]);
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        set<vector<int>> output;
        generate(output,0,nums);
        return vector(output.begin(),output.end());
    }
};