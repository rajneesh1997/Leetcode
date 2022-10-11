class Solution {
    List<List<Integer>> ans = new ArrayList();
    List<Integer> arr = new ArrayList();
    public void create(int[] nums, int start){
        if(start > nums.length){
            return;
        }
        ans.add(new ArrayList(arr));
        for(int i = start; i < nums.length; i++){
            arr.add(nums[i]);
            create(nums,i+1);
            arr.remove(arr.size() - 1);
        }
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        create(nums,0);
        return ans;
    }
}