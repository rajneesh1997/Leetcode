class Solution {
public:
    bool ans = false;
    void dfs(int source, int destination, unordered_map<int,vector<int>>& map, vector<bool>& vis){
        if(vis[source]) return;
        vis[source] = true;
        for(auto x:map[source]){
            if(x==destination){
                ans = true;
                return;
            }
            dfs(x,destination,map,vis);
        }
    }
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        if(source == destination) return true;
        unordered_map<int,vector<int>> map;
        for(auto x:edges){
            map[x[0]].push_back(x[1]);
            map[x[1]].push_back(x[0]);
        }
        vector<bool> vis(n,false);
        dfs(source,destination,map,vis);
        return ans;
    }
};