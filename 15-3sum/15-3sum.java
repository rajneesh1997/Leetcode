class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> ans = new HashSet();
        for(int i = 0; i < nums.length; i++){
            List<Integer> arr = new ArrayList();
            HashMap<Integer,Integer> map = new HashMap();
            int target = 0 - nums[i];
            arr.add(nums[i]);
            for(int j = i + 1; j < nums.length; j++){
                if(map.containsKey(target-nums[j])){
                    arr.add(target-nums[j]);
                    arr.add(nums[j]);
                    Collections.sort(arr);
                    ans.add(new ArrayList(arr));
                    arr.remove(arr.size()-1);
                    arr.remove(arr.size()-1);
                }
                else{
                    map.put(nums[j],0);
                }
            }
        }
        List<List<Integer>> fans = new ArrayList(ans);
        return fans;
    }
}