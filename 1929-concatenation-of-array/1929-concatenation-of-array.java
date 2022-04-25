class Solution {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length;
        int[] ans = new int[2*size];
        int j = 0;
        while(j < 2*size){
            for(int i = 0; i < size; i++){
                ans[j++] = nums[i];
            }
        }
        return ans;
    }
}