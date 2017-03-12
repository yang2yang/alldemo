package sortdemo;

/**
 * *  author:jack 2017年02月2017/2/25日
 */
public class Solution {

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2){
        ListNode listNode = new ListNode(0);
        ListNode copyListNode = listNode;
        while(l1 != null || l2 != null){
            if(l1 == null && l2 != null){
                listNode.next = l2;
                l2 = l2.next;
            }else if(l1 != null && l2 == null){
                listNode.next = l1;
                l1 = l1.next;
            }else{
                if(l1.val < l2.val){
                    listNode.next = l1;
                    l1 = l1.next;
                }else{
                    listNode.next = l2;
                    l2 = l2.next;
                }
            }
            listNode = listNode.next;
        }

        return copyListNode.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        ListNode listNode = new ListNode(0);
        ListNode copyListNode = listNode;
        while(l1 != null || l2 != null){
            if(l1 == null && l2 != null){
                listNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }else if(l1 != null && l2 == null){
                listNode.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                if(l1.val < l2.val){
                    listNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else{
                    listNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            listNode = listNode.next;
        }

        return copyListNode.next;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //定义abc是遍历指针
        ListNode abc = null;
        //定义abc1为头指针
        ListNode abc1 = null;
        //当l1和l2都不为空的时候，才进行遍历归并
        while (l1 != null || l2 != null) {
            //分成三种情况  这种是l1为null,l2有值(除了这三种情况下，没有其他情况)
            if (l1 == null && l2 != null) {
                if (abc == null) {
                    abc = new ListNode(l2.val);
                    abc1 = abc;
                } else {
                    abc1.next = new ListNode(l2.val);
                    abc1 = abc1.next;
                }
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {//分成三种情况  这种是l2为null,l1有值
                if (abc == null) {
                    abc = new ListNode(l1.val);
                    abc1 = abc;
                } else {
                    abc1.next = new ListNode(l1.val);
                    abc1 = abc1.next;
                }
                l1 = l1.next;
            } else {//分成三种情况  这种是l1,l2都有值的情况下
                if (l1.val < l2.val) {
                    if (abc == null) {
                        abc = new ListNode(l1.val);
                        abc1 = abc;
                    } else {
                        abc1.next = new ListNode(l1.val);
                        abc1 = abc1.next;
                    }
                    l1 = l1.next;
                } else {
                    if (abc == null) {
                        abc = new ListNode(l2.val);
                        abc1 = abc;
                    } else {
                        abc1.next = new ListNode(l2.val);
                        abc1 = abc1.next;
                    }
                    l2 = l2.next;
                }
            }
        }
        return abc;
    }

}