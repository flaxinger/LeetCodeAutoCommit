/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(!l1 && !l2) return nullptr;
        ListNode* root = new ListNode();
        ListNode* it = root;
        
        while(l1 || l2){
            if(l1 && !l2){
                it->val = l1->val;
                l1 = l1->next;
            }
            else if(!l1 && l2){
                it->val = l2->val;
                l2 = l2->next;
            }
            else{
                if(l1->val < l2->val){
                    it->val = l1->val;
                    l1 = l1->next;
                }
                else{
                    it->val = l2->val;
                    l2 = l2->next;
                }
            }
            if(l1 || l2){
                it->next = new ListNode();
                it = it->next;
            }
        }
        // it = nullptr;
        // it->val = nullptr;
        return root;
    }
};