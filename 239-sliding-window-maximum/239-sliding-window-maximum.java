class Solution {
    Deque<Integer> deque = new ArrayDeque<>();
    int[] ans;
    public void clean(int i, int k, int[] nums){
        if(!deque.isEmpty() && deque.peekFirst() == i - k)
            deque.pollFirst();
        
        while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
            deque.pollLast();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ans = new int[n-k+1];
        int maxi = nums[0];
        for(int i = 0; i < k; i++){
            clean(i,k,nums);
            deque.offerLast(i);
            maxi = Math.max(maxi, nums[i]);
        }
        int itr = 0;
        ans[itr++] = maxi;
        for(int j = k; j < n; j++){
            clean(j,k,nums);
            deque.offerLast(j);
            ans[itr++] = nums[deque.getFirst()];
            
        }
        return ans;
    }
}