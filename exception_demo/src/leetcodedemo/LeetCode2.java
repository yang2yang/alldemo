package leetcodedemo;

import sortdemo.ListNode;

/**
 * *  author:jack 2017年02月2017/2/28日
 */
public class LeetCode2 {

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
//        ListNode copyl1 = l1;
//        for(int i = 0;i <= 9;i++){
//            copyl1.next = new ListNode(9);
//            copyl1 = copyl1.next;
//        }
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode ln = leetCode2.addTwoNumbers2(null,null);
        while(ln != null){
            System.out.println(ln.val);
            ln = ln.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode copyListNode = listNode;
        int overFlow = 0;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                listNode.next = new ListNode((l1.val + l2.val + overFlow)%10);
                overFlow = (l1.val + l2.val + overFlow) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 == null && l2 != null){
                listNode.next = new ListNode((l2.val + overFlow)%10);
                overFlow = (l2.val + overFlow) / 10;
                l2 = l2.next;
            }else{
                listNode.next = new ListNode((l1.val + overFlow)%10);
                overFlow = (l1.val + overFlow) / 10;
                l1 = l1.next;
            }
            listNode = listNode.next;


        }

        return copyListNode.next;

    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode copyListNode = listNode;
        Long a = transfer(l1);
        Long b = transfer(l2);
        Long c = a + b;
        String s = Long.toString(c);
        for (int i = s.length() - 1; i >= 0; i--) {
            listNode.next = new ListNode(Integer.parseInt(s.substring(i,i+1)));
            listNode = listNode.next;
        }
        return copyListNode.next;
    }

    public Long transfer(ListNode l) {
        Long sum = 0L;
        while (l != null) {
            sum = sum * 10 + l.val;
            l = l.next;
        }
        return sum;
    }
}

