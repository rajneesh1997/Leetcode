class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] row : reservedSeats){
            int a = row[0];
            int b = row[1];
            map.put(a, map.getOrDefault(a, 0) | (1 << b));
        }
        int max = 0;
        for(int key : map.keySet()){
            int b = map.get(key);
            int cnt = 0;
            if((b & 60) == 0) cnt+=1; // check if seats 2,3,4,5 are available
            if((b & 960) == 0) cnt+=1; // check if seats 6,7,8,9 are available
            if((b & 240) == 0 && cnt == 0) cnt = 1; // check if seats 4,5,6,7 are available
            max += cnt;
        }
        
        return max + 2 * (n - map.size());
    }
}