class Solution {
    public String largestNumber(int[] nums) {
        String[] ans = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = "" + nums[i];
        }
        Arrays.sort(ans, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        if(ans[0].equals("0")) return "0";
        String ans2 = "";
        for(String str:ans){
            ans2 += str;
        }
        return ans2;
    }
}