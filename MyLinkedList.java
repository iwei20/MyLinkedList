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
        if(index < 0 || index > size) {
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
    
    public String remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " out of bounds in list size " + size);
        }
        
        String result;
        if(size == 1) {
            result = start.getData();
            start = null;
            end = null;
        } else if(index == 0) {
            result = start.getData();
            Node newStart = start.getNext();
            breakConnection(start, newStart);
            start = newStart;
        } else if(index == size - 1) {
            result = end.getData();
            Node newEnd = end.getPrev();
            breakConnection(newEnd, end);
            end = newEnd;
        } else {
            Node toRemove = getNode(index);
            result = toRemove.getData();
            Node prev = toRemove.getPrev();
            Node next = toRemove.getNext();
            breakConnection(prev, toRemove);
            breakConnection(toRemove, next);
            connect(prev, next);
        }
        return result;
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

    public void clear() {
        size = 0;
        start = null;
        end = null;
    }

    /*
    *@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
    *@postcondition: The size of other is reduced to 0.
    *@postcondition: The size of this is now the combined sizes of both original lists
    */
    public void extend(MyLinkedList other){
        connect(end, other.start);
        end = other.end;
        size += other.size;
        other.clear();
    }

    public String toString() {
        String result = "[";
        Node curr = start;
        for(int i = 0; i < size; ++i) {
            result += curr.getData();
            if(i != size - 1) {
                result += ", ";
            }
            curr = curr.getNext();
        }
        result += "]";
        return result;
    }

    public String toStringReversed() {
        String result = "[";
        Node curr = end;
        for(int i = 0; i < size; ++i) {
            result += curr.getData();
            if(i != size - 1) {
                result += ", ";
            }
            curr = curr.getPrev();
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

    private void breakConnection(Node before, Node after) {
        if(before.getNext() == after && after.getPrev() == before) {
            before.setNext(null);
            after.setPrev(null);
        }
    }
}