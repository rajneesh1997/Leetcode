class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet();
        HashSet<Integer> set2 = new HashSet();
        ArrayList<Integer> ans = new ArrayList();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }
        for(Integer ele : set1){
            if(set2.contains(ele))
                ans.add(ele);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}