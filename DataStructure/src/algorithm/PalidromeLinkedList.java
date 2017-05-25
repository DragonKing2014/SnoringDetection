package algorithm;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 */
class ListNode{
    int val;
    ListNode next=null;
    public ListNode(int val){
        this.val=val;
    }

}

public class PalidromeLinkedList {
    public boolean chkPalindrome(ListNode A) {
        if (A==null){
            return true;
        }
        ListNode temp=A;
        //用双向链表模拟栈
        LinkedList<ListNode> stacklist=new LinkedList<>();
        stacklist.addFirst(temp);
        while(temp.next!=null){
            stacklist.addFirst(temp.next);
            temp=temp.next;
        }

        while(A!=null){
            ListNode node=stacklist.removeFirst();
            if (A.val!=node.val){
                return false;
            }
            A=A.next;
        }
        return true;

    }
    public static void main(String args[]){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(99);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(1);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        System.out.println(new PalidromeLinkedList().chkPalindrome(node1));
    }

}
