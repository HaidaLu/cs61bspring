public class MyLinkedListDequeTest {
    public static void main(String[] args) {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        System.out.println(lld1.isEmpty());
        lld1.addFirst(1);
        lld1.addFirst(2);
        System.out.println(lld1.removeLast());
        System.out.println(lld1.isEmpty());

    }
}
