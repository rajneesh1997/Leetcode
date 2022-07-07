class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int num : nums){
            String str = "" + num;
            if(str.length() % 2 == 0)
                ans++;
        }
        return ans;
    }
}