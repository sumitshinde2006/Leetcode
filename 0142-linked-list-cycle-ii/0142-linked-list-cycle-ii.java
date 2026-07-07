/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
           return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        boolean hascycyle=false;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
           
            if(slow==fast){
                hascycyle=true;
                break;
            }
        }
            if(!hascycyle){
                return null;
            }
        
            ListNode entry=head;
            while(entry!=slow){
                slow=slow.next;
                entry=entry.next;
            }return entry;
        
    }
}