class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int countShouldBe = (int)Math.floor(n/3);
        int count = 1;
        List<Integer> ans = new ArrayList<>();
        for(int i = 1 ; i <= n; i++){
            if(i != n && nums[i] == nums[i-1]){
                count++;
            } else {
                if(count > countShouldBe){
                    ans.add(nums[i-1]);
                }
                count = 1;
            }
        }
        return ans;
    }
}