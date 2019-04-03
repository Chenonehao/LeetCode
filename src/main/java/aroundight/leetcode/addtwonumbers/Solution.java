package aroundight.leetcode.addtwonumbers;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        ListNode tmp = null;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(val);
            if (listNode == null) {
                listNode = newNode;
                listNode.next = null;
                tmp = listNode;
            } else {
                tmp.next = newNode;
                newNode.next = null;
                tmp = newNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            addleft(tmp, l1);
        } else if (l2 != null) {
            addleft(tmp, l2);
        } else if (carry != 0) {
            addend(tmp);
        }


        return listNode;
    }

    public void addleft(ListNode tmp, ListNode l) {
        while (l != null) {
            int val = l.val + carry;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = null;
            tmp.next = newNode;
            tmp = newNode;
            l = l.next;

        }
        if (carry != 0) {
            addend(tmp);
        }

    }

    public void addend(ListNode tmp) {
        ListNode newNode = new ListNode(1);
        newNode.next = null;
        tmp.next = newNode;
    }


}