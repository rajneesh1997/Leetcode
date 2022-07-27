class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap();
        ArrayList<String> ans = new ArrayList();
        for(String word : words){
            map.put(word, map.getOrDefault(word,0) + 1);
        }
        
        PriorityQueue<String> pQueue = new PriorityQueue<>((a,b) -> {
            int freq1 = map.get(a);
            int freq2 = map.get(b);
            if(freq1 == freq2) return b.compareTo(a);
            return freq1-freq2;
        });
        
        for(String word : map.keySet()){
            pQueue.offer(word);
            if(pQueue.size() > k){
                pQueue.poll();
            }
        }
        
        while(!pQueue.isEmpty()){
            ans.add(pQueue.poll());
        }
        
        Collections.reverse(ans);
        return ans;
    }
}