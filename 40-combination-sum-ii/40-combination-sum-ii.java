class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int n;
    public void f(int ind, int[] candidates, int target, List<Integer> tmp){
        if(target == 0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int k = ind; k < n; k++){
            if(k != ind && candidates[k] == candidates[k-1]){
                continue;
            } else {
                if(candidates[k] <= target){
                    tmp.add(candidates[k]);
                    f(k+1,candidates,target-candidates[k],tmp);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        n = candidates.length;
        f(0, candidates, target, new ArrayList<>());
        return ans;
    }
}