class Solution {
public:
    int lengthOfLastWord(string s) {
        int foundWrd = 0, ans = 0;
        for(int i = s.size()-1; i > -1; i--){
            if(foundWrd == 0 and s[i] == ' ') continue;
            if(foundWrd == 1 and s[i] == ' ') break;
            if(s[i] != ' '){
                foundWrd = 1;
                ans++;
            }
        }
        return ans;
    }
};