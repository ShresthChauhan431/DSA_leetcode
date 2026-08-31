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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};

        int hi = -1;
        int prevc = -1;
        int min = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        while(curr.next != null){
            ListNode next = curr.next;
            if((curr.val > prev.val && curr.val > next.val) || 
                (curr.val < prev.val && curr.val < next.val)){
                if(hi == -1)
                    hi = index;
                else
                    min = Math.min(min, index - prevc);
                prevc = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if(min == Integer.MAX_VALUE) 
            return new int[]{-1, -1};
        
        int max = prevc - hi;
        return new int[]{min, max};
    }
}