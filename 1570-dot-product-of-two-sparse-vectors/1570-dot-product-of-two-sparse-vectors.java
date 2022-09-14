class SparseVector {
    int[] arr;
    SparseVector(int[] nums) {
        this.arr = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int size = this.arr.length;
        int ans = 0;
        for(int i = 0; i < size; i++){
            ans += (this.arr[i] * vec.arr[i]);
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);