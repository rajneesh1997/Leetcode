class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length-1;
        while(i < j){
            if(nums[j] == val)
                j--;
            else if(nums[i] != val)
                i++;
            else if(nums[i] == val && nums[j] != val){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        for(i = 0; i < nums.length; i++){
            if(nums[i] == val)
                return i;
        }
        return nums.length;
    }
}