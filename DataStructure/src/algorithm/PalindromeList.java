package algorithm;

import java.util.*;

/**
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 */
//链表结构
class Node {
    //本结点的数据
    int val;
    //保存下一个结点的引用
    Node next = null;

    Node(int val) {
        this.val = val;
    }
}

public class PalindromeList {
    public boolean chkPalindrome(Node A) {
        Node p = A;
        Node q = A;

        while (true) {
            if (q.next == null) {
                break;
            } else if (q.next.next == null) {
                q = q.next;
                p=p.next;
                break;
            }
            p = p.next;
            q = q.next.next;
        }

        Stack<Node> st = new Stack<>();
        while (true) {
            if (q.next == null) {
                st.push(q);
                break;
            }
            st.push(q);
        }
        p = A;

        boolean flag = true;

        while (!st.isEmpty()) {
            Node node = st.pop();
            if (p.val != node.val) {
                flag = false;
                break;
            }
        }
        return flag;

    }
}
