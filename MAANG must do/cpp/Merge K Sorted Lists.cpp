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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        vector<int> v;
        
        // Step 1: Extract all node values
        for (int i = 0; i < lists.size(); i++) {
            ListNode* node = lists[i];
            while (node != NULL) {
                v.push_back(node->val);
                node = node->next;
            }
        }

        // Step 2: Sort the values
        sort(v.begin(), v.end());

        // Step 3: Build the new sorted list
        ListNode* newhead1 = new ListNode(-1); // Dummy node
        ListNode* newhead = newhead1;
        for (int i = 0; i < v.size(); i++) {
            newhead->next = new ListNode(v[i]);
            newhead = newhead->next;
        }

        return newhead1->next;
    }
};