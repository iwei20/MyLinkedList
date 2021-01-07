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
        Node toAppend = new Node(value);
        if(size == 0) {
            start = toAppend;
            end = toAppend;
        } else {
            connect(end, toAppend);
            end = toAppend;
        }
        size++;
        return true;
    }

    public void add(int index, String value) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
        }

        if(index == size) {
            add(value);
        } else if(index == 0) {
            Node toInsert = new Node(value);
            connect(toInsert, start);
            start = toInsert;
            size++;
        } else {
            Node there = getNode(index);
            Node before = there.getPrev();
            Node toInsert = new Node(value);
            connect(before, toInsert);
            connect(toInsert, there);
            size++;
        }
    }
    
    public String get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
        }
        return getNode(index).getData();
    }

    public String set(int index, String value) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
        }
        Node there = getNode(index);
        String result = there.getData();
        there.setData(value);
        return result;
    }

    public String toString() {
        String result = "[";
        Node curr = start;
        for(int i = 0; i < size; ++i) {
            result += curr;
            if(i != size - 1) {
                result += ", ";
            }
            curr = curr.getNext();
        }
        result += "]";
        return result;
    }

    private Node getNode(int index) {
        Node curr = start;
        for(int i = 0; i < index; ++i) {
            curr = curr.getNext();
        }
        return curr;
    }

    private void connect(Node before, Node after) {
        before.setNext(after);
        after.setPrev(before);
    }
}