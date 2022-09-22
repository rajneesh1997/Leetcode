class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        f(0,n-1,new ArrayList<>(),s);
        return ans;
    }
    
    public void f(int start, int end, List<String> str, String s){
        if(start > end){
            ans.add(new ArrayList(str));
            return;
        }
        for(int i = start; i <= end; i++){
            if(isPalin(start,i,s)){
                str.add(s.substring(start,i+1));
                f(i+1,end,str,s);
                str.remove(str.size()-1);
            }
        }
    }
    
    public boolean isPalin(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}