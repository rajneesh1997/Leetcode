class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a, b) -> b - a);
        int ans = 0;
        for(int stone : stones){
            pQueue.offer(stone);
        }
        while(pQueue.size() > 1){
            int y = pQueue.poll();
            int x = pQueue.poll();
            // System.out.println()
            if(x != y){
                pQueue.offer(y-x);
            }
        }
        return pQueue.peek() == null ? 0 : pQueue.peek();
    }
}