package lec8;

public class UsingInheritance {
    Stack stack = new Stack();
    stack.push(5);
}

//delegation example;
class Stack{
    private Vector mySecret;
    public Stack(){
        mySecret = new Vector();
    }
    public Object push(Object item){
        mySecret.addElement(item);
        return item;
    }
    public boolean Empty(){
        return mySecret.isEmpty();
    }
    public Object pop(){
        Object obj = top();
        mySecret.removeElementAt(size() - 1);
        return obj;
    }
}