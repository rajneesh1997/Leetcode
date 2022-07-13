class Solution {
    public int pivotIndex(int[] nums) {
        int size = nums.length;
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = nums[0];
        right[size-1] = nums[size-1];
        for(int i = 1; i < size; i++){
            left[i] = nums[i] + left[i-1];
            right[size-1-i] = nums[size-1-i] + right[size-i];
        }
        // for(int i = size - 2; i > -1; i--){
        //     right[i] = nums[i] + right[i+1];
        // }
        for(int i = 0; i < size; i++){
            if(left[i] == right[i])
                return i;
        }
        return -1;
    }
}