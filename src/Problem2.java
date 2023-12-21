public class Problem2 {
    public static void main(String[] args) {
        ListNode first = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode())));
        ListNode second = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))));
        ListNode listNode = addTwoNumbers(first, second);
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1.next;
        ListNode tmp2 = l2.next;
        int initValue = l1.val + l2.val;
        boolean flag = initValue >= 10;
        ListNode current = new ListNode();
        ListNode res = new ListNode(initValue >= 10 ? 0 : initValue, current);
        while (tmp1 != null && tmp2 != null) {
            int init = tmp1.val + tmp2.val + (flag ? 1 : 0);
            current = new ListNode(init >= 10 ? 0 : init);
            current = current.next;
            flag = init >= 10;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        if (tmp1 == null) {
            if (!flag) {
                current = tmp2;
            } else {
                while (tmp2 != null) {
                    int init = tmp2.val + (flag ? 1 : 0);
                    current = new ListNode(init >= 10 ? 0 : init);
                    current = current.next;
                    flag = init >= 10;
                    tmp2 = tmp2.next;
                }
            }
        }
        if (tmp2 == null) {
            if (!flag) {
                current = tmp2;
            } else {
                while (tmp1 != null) {
                    int init = tmp1.val + (flag ? 1 : 0);
                    current = new ListNode(init >= 10 ? 0 : init);
                    current = current.next;
                    flag = init >= 10;
                    tmp1 = tmp1.next;

                }
            }
        }
        return res;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}