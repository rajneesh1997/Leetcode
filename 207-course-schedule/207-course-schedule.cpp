class Solution {
public:
    bool ans = true;
    void dfs(vector<int> adj[],unordered_map<int,int>& um, int crr){
        if(um[crr]==0){
            um[crr] = 1;
            for(auto x:adj[crr])
                dfs(adj,um,x);
            um[crr]=2;
        }else{
            if(um[crr]==1){
                ans = false;
                return;
            }
        }
    }
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> adj[numCourses];
        for(auto x:prerequisites){
            adj[x[0]].push_back(x[1]);
        }
        unordered_map<int,int> um;
        for(int i = 0; i < numCourses; i++){
                dfs(adj,um,i);
        }
        return ans;
    }
};