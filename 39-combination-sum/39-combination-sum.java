class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int[] candidates, int target, List<Integer> arr,int index){
        if(target == 0){
            ans.add(new ArrayList<>(arr));
        }
        if(target < 0){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(target >= candidates[i]){
                arr.add(candidates[i]);
                dfs(candidates,target-candidates[i],arr,i);
                arr.remove(arr.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> arr = new ArrayList<>();
        dfs(candidates,target,arr,0);
        return ans;
    }
}