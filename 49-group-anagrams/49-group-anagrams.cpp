class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string,vector<string>> mv;
        for(auto word:strs){
            string newWord = word;
            sort(newWord.begin(),newWord.end());
            mv[newWord].push_back(word);
        }
        vector<vector<string>> ans;
        for(auto x:mv){
            ans.push_back(x.second);
        }
        return ans;
    }
};