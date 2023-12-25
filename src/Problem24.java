public class Problem24 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode listNode = swapPairs(node);
        System.out.println();
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (next.next != null) {
            ListNode tmp = next.next;
            next.next = head;
            head.next = swapPairs(tmp);
        } else {
            next.next = head;
            head.next = null;
        }
        return next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
