class Solution {
    List<List<Integer>> ans = new ArrayList();
    List<Integer> arr = new ArrayList();
    public void create(int[] nums, int size, int start){
        if(size < 0) return;
        if(size == 0){
            ans.add(new ArrayList<Integer>(arr));
            return;
        }
        for(int i = start; i < nums.length; i++){
            arr.add(nums[i]);
            create(nums,size-1,i+1);
            arr.remove(arr.size() - 1);
        }
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(arr);
        for(int i = 1; i <= nums.length; i++){
            create(nums,i,0);
        }
        return ans;
    }
}