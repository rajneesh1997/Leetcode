class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    public void f(int ind,List<Integer> tmp){
        if(ind > this.nums.length){
            // ans.add(new ArrayList<>(tmp));
            return;
        }
        ans.add(new ArrayList<>(tmp));
        for(int i = ind; i < this.nums.length; i++){
            if(i != ind && nums[i] == nums[i-1])
                continue;
            tmp.add(nums[i]);
            f(i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        f(0,new ArrayList<>());
        return ans;
    }
}