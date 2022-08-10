class Solution {
    public int maxProduct(int[] nums) {
        int arr[] = new int[nums.length];
        arr[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(arr[i-1] == 0){
                arr[i] = nums[i];
            } else {
                arr[i] = arr[i-1] * nums[i];
            }
        }
        int brr[] = new int[nums.length];
        brr[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i > -1; i--){
            if(brr[i+1] == 0){
                brr[i] = nums[i];
            } else {
                brr[i] = brr[i+1] * nums[i];
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            ans = Math.max(ans, Math.max(arr[i], brr[i]));
        }
        return ans;
    }
}