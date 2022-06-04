class Solution {
    public int findCenter(int[][] edges) {
        HashSet<Integer> set = new HashSet();
        for(int[] edge: edges){
            for(int node : edge){
                if(set.contains(node)) return node;
                set.add(node);
            }
        }
        return 0;
    }
}