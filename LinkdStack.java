public class LinkdStack<E> implements Stack<E>{
    SinglyLinkedList<E> list = new SinglyLinkedList<>();

    @Override
    public int size() {
return list.size();    }

    @Override
    public boolean isEmpty() {
return list.isEmpty();    }

    @Override
    public void puch(E lelement) {
list.addFirst(lelement);    }

    @Override
    public E top() {
return list.first();    }

    @Override
    public E pop() {
return list.removeFirst();    }
    
    
}
