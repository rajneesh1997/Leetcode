class Solution {
    int[] link = new int[1001];
    public int removeStones(int[][] stones) {
        int len = stones.length;
        for(int i = 0; i < len; i++){
            link[i] = i;
        }
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++){
            if (link[i] == i) count++;
        }
        
        return len - count;
    }
    
    public int find(int x){
        while(x != link[x])
            x = link[x];
        return x;
        
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
        link[b] = a;
    }
}