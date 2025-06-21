/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int cnt(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = cnt(head);
        ListNode temp = head;

        // Case: removing the only node
        if (n == k && temp.next == null)
            return null;

        // Case: remove the head node
        if (n == k)
            return temp.next;

        // Move to the node just before the one to delete
        for (int i = 0; i < k - n - 1; i++) {
            temp = temp.next;
        }

        // Case: remove the last node
        if (n == 1) {
            temp.next = null;
            return head;
        }

        // General case
        ListNode next = temp.next.next;
        temp.next = next;

        return head;
    }
}