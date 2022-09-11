class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int num : nums){
            if(num > 0){
                if((num-1) < n)
                    arr[num-1] = 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(arr[i] == 0)
                return i+1;
        }
        return n+1;
    }
}