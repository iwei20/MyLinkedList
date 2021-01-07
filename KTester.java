public class KTester {
    public static void main(String[] args) {
        MyLinkedList a = new MyLinkedList();
        MyLinkedList b = new MyLinkedList();
        for(int i = 0; i < 10; i++){
        if(i < 5){
            a.add(i+"");
        }else{
            b.add(i+"");
        }
        }
        System.out.println();
        System.out.println("A:"+a+a.size());
        System.out.println("B:"+b+b.size());

        a.extend(b);
        System.out.println("A:"+a+a.size());
        System.out.println("B:"+b+b.size());
        System.out.println("A reversed:"+a.toStringReversed()+a.size());
        System.out.println("B reversed:"+b.toStringReversed()+b.size());
    }
}
