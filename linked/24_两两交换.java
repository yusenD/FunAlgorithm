import java.util.Collections;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode hair = new ListNode();
        ListNode cur = hair;
        Arrays.sort(new int[10], Collections.reverseOrder());
        while(head != null){
            if(head.next == null){
                cur.next = head;
                break;
            }else{
                ListNode next = head.next.next;
                cur.next = head.next;
                head.next.next = head;
                head.next = next;
                cur = cur.next.next;
                head = next;

            }
        }
        return hair.next;
    }
}