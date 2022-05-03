class Solution {
    boolean found = true;
    String ans = "";
    public void solve(String str, int n, String[] nums){
        if(str.length() == n){
            found = Arrays.asList(nums).contains(str);
            ans = str;
            return;
        }
        if(found){
            str = str + "0";
            solve(str,n, nums);
            str = str.substring(0,str.length()-1);
            str = str + "1";
            solve(str,n, nums);
            str = str.substring(0,str.length()-1);
        }
        
    }
    public String findDifferentBinaryString(String[] nums) {
        if(nums[0].equals("1")) return "0";
        if(nums[0].equals("0")) return "1";
        int n = nums.length;
        solve("",n,nums);
        return ans;
    }
}