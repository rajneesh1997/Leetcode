class Solution {
    public void countSort(int[] nums, int n, int exp){
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count,0);
        for(int i = 0; i < n; i++){
            count[(nums[i] / exp) % 10]++;
        }
        for(int i = 1; i < 10; i++){
            count[i] += count[i-1];
        }
        for(int i = n-1; i >= 0; i--){
            output[count[(nums[i] / exp) % 10] - 1] = nums[i];
            // System.out.println(count[(nums[i] / exp) % 10] + " " + nums[i]);
            count[(nums[i] / exp) % 10]--;
        }
        for(int i = 0; i < n; i++){
            nums[i] = output[i];
        }
        // for(int i : nums)
        //     System.out.print(i + " ");
        // System.out.println();
    }
    public void radixSort(int[] nums, int n){
        int m = Arrays.stream(nums).max().getAsInt();
        for(int exp = 1; m / exp > 0 ; exp *= 10)
            countSort(nums,n,exp);
    }
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        radixSort(nums,nums.length);
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++)
            ans = Math.max(ans,nums[i] - nums[i-1]);
        return ans;
    }
}