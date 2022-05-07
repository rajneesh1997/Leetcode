class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int num: nums1){
            if(map.containsKey(num) == false){
                map.put(num,1);
            } else {
                int a = map.get(num);
                a++;
                map.put(num,a);
            }
        }
        ArrayList<Integer> list = new ArrayList();
        for(int num:nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                int a = map.get(num);
                a--;
                map.put(num,a);
                list.add(num);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }
}