class Solution {
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        for(int num : nums)
            arr[num]++;
        int ans = 0;
        for(int i = 0; i < 101; i++)
            if(arr[i] == 1)
                ans += i;
        return ans;
    }
}