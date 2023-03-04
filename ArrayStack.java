public class ArrayStack<E> implements Stack<E>{
public  final static int CAPACITY=1000;
    private E[] data;
    private int t=-1;

    public ArrayStack() {
        this(CAPACITY);
    }
      public ArrayStack(int c) {
          data = (E[]) (E) new Object [c];
          
    }
    
    
    public int size() {
return t+1;
    }

    @Override
    public boolean isEmpty() {
return (t == -1);
    }

    public void puch(E e) {
        if(isEmpty()){
            System.out.println("Stack is full !");
            return;
        }
        data[t++]=e;
    }

    @Override
    public E top() {
        if(isEmpty())
            return null;
        return data [t];
    }

    @Override
    public E pop() {
        if(isEmpty())
            return null;
          E s =data[t];      
        data[t]=null;
        t--;
        return s;  
        
    }
    
}
