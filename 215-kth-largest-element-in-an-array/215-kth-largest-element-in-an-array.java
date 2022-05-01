class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        for(int num:nums){
            pQueue.add(new Integer(num));
        }
        int n = nums.length;
        while(n-- != k){
            pQueue.poll();
        }
        return pQueue.peek();
    }
}