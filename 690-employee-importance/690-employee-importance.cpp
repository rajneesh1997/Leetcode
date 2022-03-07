/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
public:
    void dfs(int id, unordered_map<int,int>& importance, unordered_map<int,vector<int>>& subordinates){
        for(auto x:subordinates[id]){
            dfs(x,importance,subordinates);
            importance[id] += importance[x];
        }
    }
    int getImportance(vector<Employee*> employees, int id) {
        unordered_map<int,int> importance;
        unordered_map<int,vector<int>> subordinates;
        for(auto x:employees){
            importance[x->id] = x->importance;
            subordinates[x->id] = x->subordinates;
        }
        dfs(id,importance,subordinates);
        return importance[id];
    }
};