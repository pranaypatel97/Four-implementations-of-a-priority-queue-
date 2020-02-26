
public class FourStacks extends MyQueue{
	// global variables
	private static MyStack stack1 = new MyStack(new Job[100]);
	private static MyStack stack2 = new MyStack(new Job[100]);
	private static MyStack stack3 = new MyStack(new Job[100]);
	private static MyStack stack4 = new MyStack(new Job[100]);
	private MyStack[] allStacks;
	// constructor 
	public FourStacks(MyStack [] allStacks){
		this.allStacks = allStacks;
		allStacks[0] = stack1;
		allStacks[1] = stack2;
		allStacks[2] = stack3;
		allStacks[3] = stack4;
	}
	
	public static MyStack getStack1() {
		return stack1;
	}
	public static void setStack1(MyStack stack1) {
		FourStacks.stack1 = stack1;
	}
	public static MyStack getStack2() {
		return stack2;
	}
	public static void setStack2(MyStack stack2) {
		FourStacks.stack2 = stack2;
	}
	public static MyStack getStack3() {
		return stack3;
	}
	public static void setStack3(MyStack stack3) {
		FourStacks.stack3 = stack3;
	}
	public static MyStack getStack4() {
		return stack4;
	}
	public static void setStack4(MyStack stack4) {
		FourStacks.stack4 = stack4;
	}
	// add method that adds to the appropriate stack based on the priority.
	public void add(Job x){
		if(x.getPriority() >= 0 && x.getPriority() <= .25){
			stack1.add(x);
		}
		else if(x.getPriority() > .25 && x.getPriority() <= .5){
			stack2.add(x);
		}
		else if(x.getPriority() > .5 && x.getPriority() <= .75){
			stack3.add(x);
		}
		else{
			stack4.add(x);
		}
	}
	// basic empty that checks to see if all four stacks are empty.
	public boolean empty(){
		if(stack1.getNumElements() == 0 && stack2.getNumElements() == 0 && stack3.getNumElements() == 0 && stack4.getNumElements() == 0){
			return true;
		}
		else{
			return false;
		}
		
	}
	// pop method that pops based on which stack is empty starting from 4 -> 1
	public Job pop(){

		if(stack4.empty()!= true){

			return stack4.pop();
		}
		else if(stack3.empty() != true){
			return stack3.pop();
		}
		else if(stack2.empty()!= true){
			return stack2.pop();
		}
		else{
			return stack1.pop();
		}
		
		}
	
	
	
}
