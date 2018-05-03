package com.elearning.chapter2.interviewquestion5_linkedlist;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    ListNode(int val) {
        this.val = val;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int value) {
        this.val = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
