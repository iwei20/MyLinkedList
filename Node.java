public class Node{
    private String data;
    private Node next,prev;
    //write get/set methods for all three instance variables.
    public Node(String value) {
        data = value;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}