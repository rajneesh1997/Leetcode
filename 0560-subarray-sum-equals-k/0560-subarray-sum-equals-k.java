class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        count.put(0,1);
        int ans = 0;
        int prefix = 0;
        for(int num : nums){
            prefix += num;
            ans += count.getOrDefault(prefix-k,0);
            count.put(prefix, count.getOrDefault(prefix,0) + 1);
        }
        return ans;
    }
}