class Solution {
    public int[] processQueries(int[] queries, int m) {
        ArrayList<Integer> arr = new ArrayList();
        for(int i = 0; i < m; i++){
            arr.add(i+1);
        }
        ArrayList<Integer> ans = new ArrayList();
        for(int query:queries){
            int index = arr.indexOf(query);
            ans.add(index);
            arr.remove(new Integer(query));
            arr.add(0,query);
        }
        int[] ans1 = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            ans1[i] = ans.get(i);
        }
        return ans1;
    }
}