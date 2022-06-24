class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap();
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                map.put(nums2[stack.peek()],nums2[i]);
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            map.put(nums2[stack.peek()],-1);
            stack.pop();
        }
        int index = 0;
        for(int i : nums1)
            ans[index++] = map.get(i);
        return ans;
    }
}