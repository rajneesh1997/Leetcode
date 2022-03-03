class Solution {
public:
    bool ans = true;
    void dfs(int node, vector<vector<int>>& graph, unordered_map<int,int>& um, int color, vector<bool>& vis){
        if(um[node] == 0)
            um[node] = color;
        if(um[node] == color){
            if(!vis[node])
                vis[node] = true;
            else
                return;
            for(auto x:graph[node]){
                if(color == 1){
                    dfs(x,graph,um,2,vis);
                }
                else{
                    dfs(x,graph,um,1,vis);
                }
            }
        }
        else{
            ans = false;
            return;
        }
    }
    bool isBipartite(vector<vector<int>>& graph) {
        // 1 for red, 2 for blue
        vector<bool> vis(graph.size());
        unordered_map<int,int> um;
        for(int i = 0; i<graph.size();i ++){
            if(graph[i].size() and vis[i] == false)
                dfs(i,graph,um,1,vis);
            if(!ans) return ans;
        }
        
        return ans;
    }
};