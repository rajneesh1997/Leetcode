class Solution {
    public void quicksort(int[] a,int left, int right){
        if(left < right){
            int pivotindex = partition(a,left,right);
            quicksort(a,left,pivotindex-1);
            quicksort(a,pivotindex+1,right);
        }
    }
    public int partition(int[] a,int left, int right){
        int[] b = new int[right-left+1];
        int pivotindex = left + ((right-left)/2);
        int pivot = a[pivotindex];
        int acount = left;
        int bcount = 1;
        for(int i = left; i <= right; i++){
            if(i == pivotindex)
                b[0] = a[i];
            else if(a[i] < pivot || (a[i] == pivot && i < pivotindex))
                a[acount++] = a[i];
            else
                b[bcount++] = a[i];
        }
        for(int i = 0 ; i < bcount; i++){
            a[acount++] = b[i];
        }
        return right-bcount+1;
    }
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
}