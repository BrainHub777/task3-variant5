package ru.vsu.cs.buchnev;


public class SimpleLinkedQueue<T> implements SimpleQueue<T>{


    private class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }
    }
    private SimpleLinkedListNode head = null;  // first, top
    private SimpleLinkedListNode tail = null;  // last
    private int count = 0;

    @Override
    public void add(T value) {
        if (count == 0) {
            head = tail = new SimpleLinkedListNode(value);
        } else {
            tail.next = new SimpleLinkedListNode(value);
            tail = tail.next;
        }
        count++;
    }

    @Override
    public T remove() throws Exception {
        T result = element();
        head = head.next;
        if (count == 1) {
            tail = null;
        }
        count--;
        return result;
    }

    @Override
    public T element() throws Exception {
        if (count == 0) {
            throw new Exception("Queue is empty");
        }
        return head.value;
    }
    public int count(){
        return count;
    }
    public String queueToString() {
        SimpleLinkedListNode node = head;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count;i++){
            if(node!=null)
                sb.append(node.value).append(" ");
            node=node.next;
        }
        return sb.toString();
    }
}
