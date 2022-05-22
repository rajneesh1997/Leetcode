class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int num:nums){
            set.add(num);
        }
        int ans = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int crr = num;
                int currStreak = 1;
                while(set.contains(crr+1)){
                    crr++;
                    currStreak++;
                }
                ans = Math.max(ans,currStreak);
            }
        }
        return ans;
    }
}