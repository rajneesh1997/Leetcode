class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)-> b[1] - a[1]);
        HashMap<Integer,Integer> map = new HashMap();
        for(int n : nums)
            map.put(n,map.getOrDefault(n,0)+1);
        for(Integer key : map.keySet()){
            queue.offer(new int[]{key,map.get(key)});
        }
        int[] ans = new int[k];
        int i = 0;
        while(i < k){
            ans[i++] = queue.poll()[0];
        }
        return ans;
    }
}