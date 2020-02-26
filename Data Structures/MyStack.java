

// Regular Stack implementation
public class MyStack extends MyQueue {
	private Job [] stack;
	private int numElements = 0;
	private int count = 0;
	
	public MyStack(Job[] stack){
		this.stack = stack;
	}
	public boolean empty(){
		return numElements == 0;
	}
	public Job[] getStack() {
		return stack;
	}
	public void setStack(Job[] stack) {
		this.stack = stack;
	}
	public  int getNumElements() {
		return numElements;
	}
	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}
	// regular pop method
	public Job pop(){
		numElements --;
		return stack[numElements];
	}
	// regular add method
	public void add(Job j){
		stack[numElements] = j;
		numElements++;
		
	}
}

