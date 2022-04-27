class Solution {
    
    List<List<Integer>> ans = new ArrayList();
    HashMap<Integer, List<Integer>> map = new HashMap();
    List<Integer> arr = new ArrayList();
    
    public void traverse(int start, int end){
        arr.add(start);
        if(start == end){
            List<Integer> cloned_list = new ArrayList<Integer>(arr);
            ans.add(cloned_list);
            return;
        }
        for(int nodes : map.get(start)){
            traverse(nodes,end);
            arr.remove(arr.size() - 1);
        }
        return;
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int i = 0;
        for(int[] nodes:graph){
            map.putIfAbsent(i,new ArrayList<Integer>());
            for(int node:nodes){
                map.get(i).add(node);
            }
            ++i;
        }
        int n = graph.length - 1;
        traverse(0,n);
        return ans;
    }
}