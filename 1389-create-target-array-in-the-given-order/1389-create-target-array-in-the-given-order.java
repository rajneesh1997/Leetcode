class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i = 0; i < nums.length; i++){
            if(ans[index[i]] == -1)
                ans[index[i]] = nums[i];
            else {
                int ind = index[i];
                int crr = nums[i];
                int prev = -1;
                while(ind < nums.length && ans[ind]!=-1){
                    prev = ans[ind];
                    ans[ind] = crr;
                    crr = prev;
                    ind++;
                }
                ans[ind] = crr;
            }
        }
        return ans;
    }
}