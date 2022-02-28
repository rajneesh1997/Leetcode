class Solution {
public:
    bool val = false;
    void dfs(vector<int> adj[],unordered_map<int,int>& um,int crr,vector<int>& ans){
        if(um[crr]==0){
            um[crr]=1;
            for(auto x:adj[crr])
                dfs(adj,um,x,ans);
            um[crr]=2;
            ans.push_back(crr);
            return;
        }
        else{
            if(um[crr]==1){
                val = true;
                return;
            }
        }
        
    }
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        if(numCourses == 1) return {0};
        vector<int> ans;
        vector<int> adj[numCourses];
        unordered_map<int,int> um;
        for(auto x:prerequisites){
            adj[x[0]].push_back(x[1]);
        }
        for(int i=0; i<numCourses; i++){
            dfs(adj,um,i,ans);
        }
        if(val) return {};
        return ans;
    }
};