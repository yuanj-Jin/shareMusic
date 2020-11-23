package com.yuanj.sharemusic;

import java.util.ArrayList;
import java.util.List;

public class NiuKe {
    public static ListNode ReverseList(ListNode ln) {
        ListNode re=null;
        List<Integer> list =new ArrayList();
        while(ln!=null){
           list.add(ln.val);
           ln=ln.next;
        }
        ListNode head=null;
        head=new ListNode(list.get(0));
        for (int i = 1; i < list.size(); i++) {

        }
        return re;

//        ListNode re = null;
//        ListNode head = null;
//        while (ln != null) {
//            head = ln.next;
//            ln.next = re;
//            re = ln;
//            ln = head;
//        }
//        return re;
    }

    public static void main(String[] args) {
        ListNode ln=new ListNode(1);
        ln.next=new ListNode(2);
        ln.next.next=new ListNode(3);
//        while(ln!=null){
//            System.out.println(ln.val);
//            ln=ln.next;
//        }
        ListNode re=ReverseList(ln);
        System.out.println("+++++++++++ln+++++++++++");
        while(re!=null){
            System.out.println(re.val);
            re=re.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}