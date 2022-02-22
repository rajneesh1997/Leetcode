/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    void storeItInMap(unordered_map<int,vector<int>>& m, Node* node){
        if(m[node->val].size()!=0) return;
        for(auto x:node->neighbors){
            m[node->val].push_back(x->val);
            storeItInMap(m,x);
        }
        return;
    }
    Node* cloneGraph(Node* node) {
        if(!node) return {};
        int first_node = node->val;
        unordered_map<int,vector<int>> m;
        unordered_map<int,Node*> m2;
        storeItInMap(m,node);
        for(auto x:m){
            if(m2.find(x.first)==m2.end()){
                m2[x.first] = new Node(x.first);
            }
            for(auto y:x.second){
                if(m2.find(y)==m2.end()){
                    m2[y] = new Node(y);
                    m2[x.first]->neighbors.push_back(m2[y]);
                }
                else{
                    m2[x.first]->neighbors.push_back(m2[y]);
                }
            }
        }
        return m2[first_node];
    }
};