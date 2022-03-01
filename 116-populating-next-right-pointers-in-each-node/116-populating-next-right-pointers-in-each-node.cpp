/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        if(!root) return {};
        if(!root->left and !root->right) return root;
        queue<Node*> q;
        q.push(root);
        q.push(NULL);
        while(q.size()>1){
            Node* node = q.front();
            q.pop();
            if(node){
                node->next = q.front();
                if(node->left)
                    q.push(node->left);
                if(node->right)
                    q.push(node->right);
            }
            else{
                if(!node){
                    q.push(node);
                }
            }
        }
        return root;
    }
};