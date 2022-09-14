class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            queue.offerLast(i);
        }
        
        int[] ans = new int[n];
        Arrays.sort(deck);
        for(int card : deck){
            ans[queue.pollFirst()] = card;
            if(!queue.isEmpty()){
                queue.offerLast(queue.pollFirst());
            }
        }
        
        return ans;
    }
}