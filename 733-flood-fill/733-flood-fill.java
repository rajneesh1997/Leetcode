class Solution {
    int[] dir = new int[]{0,-1,0,1,0};
    public void dfs(int[][] image, int sr, int sc, int color, int parColor){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
            return;
        if(image[sr][sc] == parColor){
            image[sr][sc] = color;
        } else {
            return;
        }
        // if(image[sr][sc] != parColor) return;
        for(int i = 0; i < 4; i++){
            int r = dir[i], c= dir[i+1];
            dfs(image, sr+r, sc+c, color, parColor);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}