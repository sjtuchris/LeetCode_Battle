/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //step1: find the middle
        ListNode mid = findMid(head);
        ListNode secondHead = mid.next;
        
        mid.next = null; //don't forget to break the list to two lists
        //step2: reverse the second list        
        secondHead = reverse(secondHead);
        //step3: merge tow lists
        head = merge(head,secondHead);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next!= null) {//slow/fast pointers to find middle in linkedlist
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }        
        ListNode newHead = null;

        while (head != null) {
            ListNode tmp = head.next;//remember use 3 pointers: pre,cur,next(tmp).
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    private ListNode merge(ListNode head, ListNode secondHead) {
        ListNode cur = head;
        while (secondHead != null) {
            ListNode tmp = secondHead.next;//use 3 pointers: cur1,cur2,cur2next(tmp)
            secondHead.next = cur.next;
            cur.next = secondHead;
            cur = cur.next.next;
            secondHead = tmp;

        }
        return head;
    }
}
