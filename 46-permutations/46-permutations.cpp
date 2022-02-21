class Solution {
public:
    void generate(vector<vector<int>>& output,int index, vector<int>& nums){
        if(nums.size() == index){
            output.push_back(nums);
            return;
        }
        for(int i = index ; i < nums.size(); i++){
            swap(nums[i],nums[index]);
            generate(output,index+1,nums);
            swap(nums[i],nums[index]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> output;
        generate(output,0,nums);
        return output;
    }
};