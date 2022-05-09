class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> arr = new ArrayList();
        arr.add(1);
        ans.add(new ArrayList(arr));
        arr.clear();
        for(int i = 2; i <= numRows; i++){
            arr.add(1);
            for(int j = 0; j < ans.get(i-2).size()-1; j++){
                int a = ans.get(i-2).get(j);
                int b = ans.get(i-2).get(j+1);
                arr.add(a+b);
            }
            arr.add(1);
            ans.add(new ArrayList(arr));
            arr.clear();
        }
        return ans;
    }
}