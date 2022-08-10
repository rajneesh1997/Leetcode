class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void traverse(int ind, int target, int[] candidates, List<Integer> arr){
        // for(int i = 0; i < arr.size(); i++){
        //     System.out.print(arr.get(i) + " ");
        // }
        // System.out.println("-------->"+target);
        // if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<Integer>(arr));
            return;
        }
        for(int i = ind; i < candidates.length; i++){
            if(target >= candidates[i]){
                arr.add(candidates[i]);
                traverse(i,target-candidates[i],candidates,arr);
                arr.remove(arr.size()-1);
            }
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> arr = new ArrayList<>();
        traverse(0, target, candidates, arr);
        return ans;
    }
}