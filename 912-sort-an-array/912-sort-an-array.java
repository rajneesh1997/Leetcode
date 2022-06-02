class Solution {
    public void mergesort(int[] nums, int left, int right){
        if(left < right){
            int mid = left + ((right-left) / 2);
            mergesort(nums,left,mid);
            mergesort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }
    public void merge(int[] a, int left, int mid, int right){
        int[] b = new int[right-left+1];
        int bcount = 0;
        int lcount = left;
        int rcount = mid+1;
        while(lcount <= mid && rcount <= right){
            if(a[lcount] < a[rcount]){
                b[bcount++] = a[lcount++];
            } else {
                b[bcount++] = a[rcount++];
            }
        }
        if(lcount > mid){
            while(rcount <= right)
                b[bcount++] = a[rcount++];
        } else {
            while(lcount <= mid)
                b[bcount++] = a[lcount++];
        }
        for(int i = 0; i < bcount; i++){
            a[left+i] = b[i];
        }
    }
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }
}