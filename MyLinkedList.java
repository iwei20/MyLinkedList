public class MyLinkedList{
    private int size;
    private Node start,end;  
    
    public MyLinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }
    public boolean add(String value) {
        if(size == 0) {
            start = end = new Node(value);
            size++;
        } else {
            end.setNext(new Node(value));
            end = end.getNext();
            size++;
        }
        return true;
    }

    public void add(int index, String value) {
        if(index > size) {
            throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
        }
        if(index == size) {
            add(value);
            return;
        }
        if(index == 0) {
            Node toInsert = new Node(value);
            start.setPrev(toInsert);
            toInsert.setNext(start);
            start = toInsert;
            return;
        }
        Node beforeInsert = start;
        for(int i = 0; i < index - 1; ++i) {
            beforeInsert = beforeInsert.getNext();
        }
        Node afterInsert = beforeInsert.getNext();
        Node toInsert = new Node(value);
        beforeInsert.setNext(toInsert);
        toInsert.setPrev(beforeInsert);
        toInsert.setNext(afterInsert);
        afterInsert.setPrev(toInsert);
        return;
    }
    
    public String get(int index);
    public String set(int index, String value);
    public String toString();
    //Any helper method that returns a Node object MUST BE PRIVATE!
}