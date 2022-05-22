class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        ArrayList<String> li = new ArrayList();
        ArrayList<String> ans = new ArrayList();
        for(int i = 0; i < digits.length(); i++){
            char chr = digits.charAt(i);
            if(ans.size() == 0){
                int len = map.get(chr).length();
                for(int j = 0; j < len; j++)
                    ans.add("" + map.get(chr).charAt(j));  
            } else {
                int len = map.get(chr).length();
                for(String val : ans){
                    for(int j = 0; j < len; j++)
                        li.add(val + map.get(chr).charAt(j));
                }
                ans.clear();
                for(String val : li){
                    ans.add(val);
                }
                li.clear();
            }
        }
        return ans;
    }
}