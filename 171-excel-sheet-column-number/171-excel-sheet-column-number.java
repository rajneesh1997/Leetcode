class Solution {
    public int titleToNumber(String columnTitle) {
        HashMap<Character,Integer> map = new HashMap();
        char c = 'A';
        for(int i = 1; i < 27; i++){
            map.put(c,i);
            c += 1;
        }
        int ans = 0, j = 0;
        for(int i = columnTitle.length()-1; i >= 0 ; i--){
            c = columnTitle.charAt(i);
            ans = ans + (int)(Math.pow(26,j) * map.get(c));
            ++j;
        }
        return ans;
    }
}