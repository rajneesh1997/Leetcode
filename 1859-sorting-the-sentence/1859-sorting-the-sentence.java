class Solution {
    public String sortSentence(String s) {
        int i = 0, n = s.length();
        String str = "", num = "";
        int count = 0;
        HashMap<String,String> map = new HashMap();
        while(i < n){
            char c = s.charAt(i);
            if(c == ' '){
                map.putIfAbsent(num,str);
                num = "";
                str = "";
                count++;
            } else if(c >= '0' && c <= '9'){
                num += c;
            } else {
                str += c;
            }
            i++;
        }
        map.putIfAbsent(num,str);
        count++;
        String ans = "";
        for(i = 1; i < count; i++){
            String key = "" + i;
            ans += map.get(key) + " ";
        }
        ans += map.get(""+count);
        return ans;
    }
}