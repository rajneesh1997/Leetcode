class Solution {
    public int coinChange(int[] coins, int amount) {
        ArrayList<Integer> arr = new ArrayList();
        for(int i = 0; i <= amount; i++){
            arr.add(Integer.MAX_VALUE-1);
        }
        arr.set(0,0);
        for(int i = 1; i <= amount; i++){
            for(int coin:coins){
                if(i-coin >= 0){
                    arr.set(i,Math.min(arr.get(i),arr.get(i-coin)+1));
                }
            }
        }
        // for(int i = 0; i <= amount; i++)
        //     System.out.println(i + " " + arr.get(i));
        return arr.get(amount) == Integer.MAX_VALUE-1 ? -1 : arr.get(amount);
    }
}