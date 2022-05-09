class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0){
            for(int i = 0; i < n; i++)
                nums1[i] = nums2[i];
        }
        int i = m-1, j = n-1;
        int pos = nums1.length-1;
        while(i > -1 && j > -1){
            if(nums2[j] > nums1[i]){
                nums1[pos--] = nums2[j--];
            } else {
                nums1[pos--] = nums1[i--];
            }
        }
        while(j > -1){
            nums1[pos--] = nums2[j--];
        }
    }
}