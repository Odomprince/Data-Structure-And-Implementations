
interface StackADT <T> {


    //public  void create(); This wont be need as we can do with the class constructor

    //Depend on the data type used under the hood this can run up 0(n).
    public  <T> T pop();

    public  void push( T t);

    public <T> T peek();
    

    public boolean isEmpty();

    public boolean isFull();



}


public class Stackarray <T> implements  StackADT<T> {
	
	
	private T [ ] data;
    private int capacity = 30;
    private int stackTop;
    
    public  Stackarray(T []t){
        data = t;
        stackTop = -1;
    }

    /*Object push == remove the top stack*/
    public void push( T t){
        if(stackTop+1 == data.length){
            System.out.println("Stack is Full You can't add more data");
        }
        else{
            data[++stackTop] = t;
        }
    }
    
    /*Object pop == remove the top stack*/

    public T pop(){
        T poped = data[stackTop];
        data[stackTop] = null; //Just make it 0(1)
        stackTop--;
        return poped;
    }

    /* Boolean isEmpty == which return boolean of whether is empty or not*/    
    public  T peek(){
        return data[stackTop];
    }

    public boolean isEmpty(){
        return stackTop == -1 ? true:false;
    }

    public boolean isFull(){
        return stackTop+1 == data.length ? true : false;
    }

    /*Object main program the top stack*/
    public static void main(String[] args) {
        String [] ary = {""};
        Stackarray Name = new Stackarray <String>(ary);
        Name.push("Max");
        Name.push("Phony");
        Name.push("ACain");
        System.out.println(Name.isEmpty());
        System.out.println(Name.isFull());
    }
	
}
