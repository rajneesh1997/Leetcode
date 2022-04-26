class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int i = 0;
        for(int[] query:queries){
            int x2 = query[0], y2 = query[1], radius = query[2], count = 0;
            for(int[] point: points){
                int x1 = point[0], y1 = point[1];
                if((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) <= radius * radius)
                    count++;
            }
            ans[i++] = count;
        }
        return ans;
    }
}