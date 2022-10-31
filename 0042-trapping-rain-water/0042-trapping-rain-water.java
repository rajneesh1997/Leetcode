class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = height[0];
        right[n-1] = height[n-1];
        
        int lmax = height[0];
        int rmax = height[n-1];
        
        for(int i = 1; i < n; i++){
            if(lmax < height[i]){
                left[i] = height[i];
                lmax = height[i];
            } else {
                left[i] = lmax;
            }
        }
        
        for(int i = n-2; i > -1; i--){
            if(rmax < height[i]){
                right[i] = height[i];
                rmax = height[i];
            } else {
                right[i] = rmax;
            }
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.min(left[i], right[i]) - height[i];
        }
        
        return ans;
    }
}