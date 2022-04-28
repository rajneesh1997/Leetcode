class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums.length == 2){
            ans[1] = 1;
            return ans;
        }
        HashMap<Integer,Integer> map = new HashMap();
        int i = 0;
        for(int num:nums){
            if(map.get(target-num) == null){
                map.put(num,i++);
            }
            else{
                ans[0] = map.get(target-num);
                ans[1] = i;
                return ans;
            }
        }
        return ans;
    }
}