public class MyLinkedList{
    private int size;
    private Node start,end;  
    
    public MyLinkedList() {
        start = new Node();
        end = new Node();
    }

    public int size() {
        return size;
    }
    
    public boolean add(String value);
    public boolean add(int index, String value);
    public String get(int index);
    public String set(int index, String value);
    public String toString();
    //Any helper method that returns a Node object MUST BE PRIVATE!
}