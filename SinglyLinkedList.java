public class SinglyLinkedList<E>{

    private Node<E> head;
    private Node<E> tail;
    private Node<E> curr; 
    private int size;

    public SinglyLinkedList() {

        head = null;
        tail = null;
        curr = null;
        size = 0;
    }

    public void clear() {// B(1)
        head = tail = null;
        size = 0;
    }
   

    public int size() {// B(1)
        return size;
    }

    public boolean isEmpty() {// B(1)
        return size == 0;
    }

    public E first() { // B(1)
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() { // B(1)
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    
    public void addFirst(E e) { // B(1)
        head = new Node<>(e, head); 
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) { // B(n)
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest); 
        }
        tail = newest; 
        size++;
    }

    public E removeFirst() {// B(1)
        if (isEmpty()) {
            return null; 
        }
        E answer = head.getElement();
        head = head.getNext(); 
        size--;
        if (size == 0) {
            tail = null; 
        }
        return answer;
    }

    
    public void add(E element, int index) {
        if (index < 0 || index > size) {
            System.out.println("Out of bound!");
            return;
        }
        Node<E> newest = new Node<E>(element, null);
        if (index == 0) 
        {
            newest.setNext(head);
            head = newest;
            if (tail == null) {
                tail = head;
            }
        } else 
        {
            curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            newest.setNext(curr.getNext());
            curr.setNext(newest);
            if (tail == curr) {
                tail = tail.getNext();
            }
        }
        size++;
    }

    
    public E remove(int index) {// O(n)
        if (index < 0 || index >= size) {
            System.out.println("Out of bound!");
            return null;
        }
        E element;
        if (index == 0) // remove from front
        {
            element = head.getElement();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            element = curr.getNext().getElement();
            if (tail == curr.getNext()) {
                tail = curr;
            }
            curr.setNext(curr.getNext().getNext());
        }

        size--;
        return element;
    }

    //
    public void moveToStart() {// B(1)
        curr = head;
    }

    public void moveToEnd() {// B(1)
        curr = tail;
    }

    public void next() {// B(n)
        if (curr != tail) {
            curr = curr.getNext();
        }
    }

    public E getValue() {// B(1)
        return curr.getElement();
    }

  
    public int CurrPos() {// B(n)
        Node<E> temp = head;
        int i = 0;
        while (temp != curr) {
            temp = temp.getNext();
            i++;
        }
        return i;
    }

    
    public void moveToPos(int pos) {// B(n)
        if (pos < 0 || pos >= size) {
            System.out.println("Position out of range!");
        } else {
            curr = head;
            for (int i = 0; i < pos; i++) {
                curr = curr.getNext();
            }
        }
    }

    public void print() {// B(n)
        curr = head;
        while (curr != null) {
            System.out.println(curr.getElement());
            curr = curr.getNext();
        }
    }

    public void DeleteSecond() {// B(1)
      if(size <2){
     System.out.println("Insufficient items !");

      }else{
          head.setNext(head.getNext().getNext());
          size--;
          if(size ==1)
              head=tail;
      }
    

    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public Node<E> getCurr() {
        return curr;
    }

    public void setCurr(Node<E> curr) {
        this.curr = curr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
 
     

}
