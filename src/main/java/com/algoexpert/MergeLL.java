package com.algoexpert;

public class MergeLL {
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "LinkedList{" +
                    "value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList four = new LinkedList(4);
        LinkedList five = new LinkedList(5);
        LinkedList six = new LinkedList(6);
        LinkedList seven = new LinkedList(7);
        LinkedList eight = new LinkedList(8);
        LinkedList nine = new LinkedList(9);
        LinkedList ten = new LinkedList(10);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        //1->2->3->4->5

        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;
        //6->7->8->9->10

        LinkedList headOne = one;
        LinkedList headTwo = six;

        LinkedList merged = mergeLinkedLists(headTwo, headOne);
        while (merged != null) {
            System.out.println(merged.value);
            merged = merged.next;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList listOne, LinkedList listTwo) {
        LinkedList p1 = listOne;
        LinkedList p2 = listTwo;
        LinkedList previous = null;

        //1->3->4->5->9
        //2->6->7
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                previous = p1;
                p1 = p1.next;
            } else {
                if (previous != null) {
                    previous.next = p2;
                }
                previous = p2;
                p2 = p2.next;
                previous.next = p1;
            }
        }
        if (p1 == null) previous.next = p2;
        return listOne.value < listTwo.value ? listOne : listTwo;
    }
}
