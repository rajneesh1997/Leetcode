class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < groupSizes.length; i++){
            int key = groupSizes[i];
            map.putIfAbsent(key, new ArrayList<Integer>());
            map.get(key).add(i);
        }
        map.forEach((k,v)-> {
            
            int times = v.size() / k;
            while(times-- != 0){
                List<Integer> tmp = new ArrayList();
                for(int i = 0; i < k; i++){
                    int a = v.get(0);
                    tmp.add(a);
                    v.remove(0);
                }
                ans.add(tmp);
            }
        });
        return ans;
    }
}