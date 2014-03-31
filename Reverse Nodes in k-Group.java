/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode node = head;
        int i = 1;
        
        while (node != null) {
            if (i % k == 0) {
                ListNode pre = start.next;
                ListNode cur = start.next.next;
                for (int j = 0; j < k - 1; j++) {
                    pre.next = cur.next;
                    cur.next = start.next;
                    start.next = cur;
                    cur = pre.next;
                }
                start = pre;
                node = cur;
            }
            else {
                node = node.next;
            }
            i++;
        }
        
        return dummy.next;
    }
}
