class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        HashMap<Integer,Integer> map = new HashMap();
        int ans = 0;
        for(int[] sides:rectangles){
            int l = sides[0];
            int b = sides[1];
            int min = Math.min(l,b);
            ans = Math.max(ans,min);
            map.compute(min, (k,v) -> (v == null) ? v = 1 : (v += 1) );
        }
        return map.get(ans);
    }
}