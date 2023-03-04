
public class MyProject {
public static void print(LinkdStack<Integer> st){
LinkdStack<Integer> st1 = new LinkdStack<>();
int x;
if(st.isEmpty()){
     System.out.println("Stack is Empty!");
        return;
}
while (!st.isEmpty()) {
x=st.pop();
System.out.println(x+" ");
st1.puch(x);
        }
        while(! st1.isEmpty())
            st.puch(st1.pop());
}
public static void ArrangStack(LinkdStack<Integer> s){
    LinkdStack<Integer> even= new LinkdStack<>();
    LinkdStack<Integer> odd= new LinkdStack<>();
  
    if(s.isEmpty()){
        System.out.println("Stack is Empty!");
        return;
    }
      int x=s.top();
   while(s.size() != 0){
      x=s.pop();
      if(x % 2 == 0 ){
          even.puch(x);   
      }else{
          odd.puch(x);
      }
   }
       while(even.size() != 0)
          s.puch(even.pop());
      while(odd.size() != 0 )
          s.puch(odd.pop());
    

    print(s);
    
    
}





static void deletmax(LinkdStack<Integer> s){
  LinkdStack<Integer> temp = new LinkdStack<Integer> ();
  int max=s.top();
  int x;
  while(s.size()!= 0){
      x=s.pop();
  if(max<x)
    max=x;
    temp.puch(x);
  } 
  while(temp.size() != 0){
      if( temp.top() != max)
        s.puch(temp.top());
      temp.pop();
  }
  
  
}


static void deletnum(LinkdStack<Integer> s,int num){

LinkdStack<Integer> t = new LinkdStack<Integer> ();
while(num != s.top())
t.puch(s.pop());
    
s.pop();


while(t.size() != 0)
    s.puch(t.pop());
    
}
static void Tr(LinkdStack<Integer> s , LinkdStack<Integer> t){
   int x=0;
   LinkdStack<Integer> temp= new LinkdStack<>();
   while (!s.isEmpty()){
       x=s.pop();
       t.puch(x);
       temp.puch(x);
   }
   while(!temp.isEmpty()){
       s.puch(temp.pop());
   }
}
public static void addsort(LinkdStack<Integer> s , int n){
   LinkdStack<Integer> temp = new LinkdStack<Integer> ();
  int x;
  while(s.size()!= 0 ){
      x=s.pop();
   if((x+1) == n){
       temp.puch(x);
       temp.puch(n);
   }else
temp.puch(x);
  }
  while(temp.size() != 0){
      s.puch(temp.pop());
  }
    
    
}

    public static void main(String[] args) {
LinkdStack<Integer> s= new LinkdStack<>();
 s.puch(8);
 s.puch(9);
 s.puch(2);
 s.puch(5);
 System.out.println("Before :");
 print(s);
 SortFirstTow(s);
 System.out.println("After :");
 print(s);
    }
    static void SortFirstTow(LinkdStack<Integer> s){
        if(s.isEmpty() || s.size() <=1){
            System.out.println("There are not enough items ");
            return ;}
        int fr=s.pop();
        int sc=s.pop();
        if(fr > sc ){
        s.puch(fr);
        s.puch(sc);
        }else{
       s.puch(sc);
      s.puch(fr);
        }
        
    }
    
    static void deletStack_in_index(LinkdStack<Integer> s , int indax ){
         if(s.isEmpty()){
            print(s);
        }
         LinkdStack<Integer> temp = new LinkdStack<Integer> ();
      if(s.size() <indax || 0>indax)
          return;
   while(s.size() == indax)
          s.pop();
       temp.puch(s.pop());
   while(!temp.isEmpty())
       s.puch(temp.pop());
      
         print(s);
        
    } 
    static void addStack_in_index(LinkdStack<Integer> s , int indax , int num){
        if(s.isEmpty())
           return;
        LinkdStack<Integer> temp = new LinkdStack<Integer> ();
        if(s.size() <indax || 0>indax)
          return;
  while(s.size() != indax)
      temp.puch(s.pop());
  s.puch(num);
  
  while(!temp.isEmpty())
      s.puch(temp.pop());
print(s);  
    }
    static void removeSmall(LinkdStack<Integer> s , int min){
       if(s.isEmpty()){
        print(s);
        return ;}
        int x;
        LinkdStack<Integer> temp = new LinkdStack<Integer> ();
                
       while(!s.isEmpty()){
           x=s.pop();
           if(x>min)
           temp.puch(x);
       }
       while(temp.size()!=0)
           s.puch(temp.pop());
           
print(s);
           
       
       
    }
public static void SumandAdd(LinkdStack<Integer> s , int min, int max){
    if(s.isEmpty()){
        print(s);
        return ;
                }
    LinkdStack<Integer> temp = new LinkdStack<Integer> ();
int sum=0;
int x;
while(!s.isEmpty()){
    x=s.pop();
    if(x>=min && x<=max)
        if(x %2 ==0)
        sum+=x;
    temp.puch(x);
}
while(!temp.isEmpty())
    s.puch(temp.pop());

if(sum != 0)
    s.puch(sum);
    
    print(s);
}
 static int Prec(char ch){   
    switch (ch){
        case '+':
            case '-':
                return 1;
                case '*' :
                case '/' :
                    return 2;
                                    case '^' :
                                        return 3;

    }
    return -1;
    

}
 static String infixToPostfix(String s){
    String result = " ";
    LinkdStack <Character> stack = new LinkdStack<Character>();
    for(int i=0 ; i< s.length(); i++)
    {
       char c = s.charAt(i);
       if(Character.isLetterOrDigit(c))
           result+=c;
       
       else if(c == '(')
           stack.puch(c);
       
       else if(c == ')')
       {
           while(! stack.isEmpty() && stack.pop() != '(')        
               result+=stack.pop();
           
           stack.pop();
       }
           
       else
       {
           while(!stack.isEmpty() && Prec(c) <= Prec(stack.top())){
               
               result+=stack.pop();
           }
           stack.puch(c);
       }
    }
       while(!stack.isEmpty()){
           if(stack.top() == '(')
               return "Invaild Stack";
           result +=stack.pop();
       }
    
    
    return result;
 }
 static  int Postfix(String ex){
 LinkdStack<Integer> stk= new LinkdStack<>();
 int x,y;
 for(int i=0 ; i<ex.length(); i++){
     if(Character.isLetterOrDigit(ex.charAt(i)))
        stk.puch( Integer.parseInt(String.valueOf(ex.charAt(i))));
     else{
         x=stk.pop();
         y=stk.pop();
       switch(ex.charAt(i)){
           case '+': 
             stk.puch(y+x);
           break;
           case '-':
               stk.puch(y-x);
               break;
               case'*':
                   stk.puch(y*x);
                   break;
               case '/':
                   stk.puch(y/x);
                   
                          
       }   
         
         
     }
 }
 return stk.pop();
 }
 static boolean isMatched(String s){
 final String open = "({[";
 final String close = ")}]";
 int count=0;
 LinkdStack <Character>stk = new LinkdStack<>();
 for(char ch : s.toCharArray()){
     if(open.indexOf(ch) != -1 ){
         stk.puch(ch);
     }else if(close.indexOf(ch)!= -1){
         if(stk.isEmpty())
             return false;
     if(close.indexOf(ch) != open.indexOf(stk.pop()))
         return false;
             }
     
 }
   return (stk.isEmpty());
 }
   
 
 }

 



