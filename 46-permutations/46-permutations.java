class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int[] nums, ArrayList<Integer> arr, boolean[] visited){
        if(arr.size() == nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                arr.add(nums[i]);
                dfs(nums,arr,visited);
                arr.remove(arr.size()-1);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(nums,arr,visited);
        return ans;
    }
}