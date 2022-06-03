class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        ArrayList<String> type = new ArrayList();
        ArrayList<String> color = new ArrayList();
        ArrayList<String> name = new ArrayList();
        for(List<String> item : items){
            type.add(item.get(0));
            color.add(item.get(1));
            name.add(item.get(2));
        }
        int ans = 0;
        if(ruleKey.equals("type")){
            for(String type_ : type){
                if(type_.equals(ruleValue))
                    ans++;
            }
        } else if(ruleKey.equals("color")){
            for(String color_ : color){
                if(color_.equals(ruleValue))
                    ans++;
            }
        } else if(ruleKey.equals("name")){
            for(String name_ : name){
                if(name_.equals(ruleValue))
                    ans++;
            }
        }
        return ans;
    }
}