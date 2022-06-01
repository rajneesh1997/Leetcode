class Solution {
    public List<String> cellsInRange(String s) {
        char start_char = s.charAt(0);
        char end_char = s.charAt(3);
        int start = Character.getNumericValue(s.charAt(1));
        int end = Character.getNumericValue(s.charAt(4));
        ArrayList<String> ans = new ArrayList();
        for(int j = (int)start_char; j <= (int)end_char; j++){
            for(int i = start; i <= end; i++){
                ans.add(""+(char)j + i);
            }
        }
        return ans;
    }
}