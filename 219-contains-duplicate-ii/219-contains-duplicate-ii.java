class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        int j = 0;
        for(int num : nums){
            if(map.containsKey(num)){
                int i = map.get(num);
                if(Math.abs(i-j) <= k)
                    return true;
                else
                    map.put(num,j);
            } else {
                map.put(num,j);
            }
            ++j;
        }
        return false;
    }
}