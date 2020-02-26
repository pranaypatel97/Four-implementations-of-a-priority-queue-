import java.util.Random;
import java.util.Scanner;

public class ExperimentQ {

	// global varibles defined 
	public static MyStack stack = new MyStack(new Job[100]);
	public static FourStacks four_stack = new FourStacks(new MyStack[4]);
	public static MyLinkedList list = new MyLinkedList();
	public static MaxHeap heap = new MaxHeap(100);
	static Random gen = new Random(100000);
	public static double quality;
	public static int c2;
	static int count = 0;
	public static String type2;
	//tester
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int l = 0;
		int type = 0;
		
		Scanner sw = new Scanner(line);
		l = sw.nextInt();
		type = sw.nextInt();
		sw.close();
		
		// determines what data structure to run the experiment on.
		if(type == 1){
			type2 = "Stack";
		}
		else if(type == 2){
			type2 = "Four Stack";
		}
		else if(type == 3){
			type2 = "Linked List";
		}
		else{
			type2 = "Heap";
		}
		// the start and end as defined in the programing assignment 4 handout
		long start = System.currentTimeMillis();
		//stage 1 
		for(int i = 0; i < l/2; i++){
			double x = gen.nextDouble();
			if(x <= 0.8){
				Job j = new Job(x, count);
				add(j, type);
				count++;
			}
			else{
				pop(type);
				c2++;
				count++;
			}
		}
		// stage 2 (basically opposite of stage 1)
		for(int i = 0; i < l/2; i++){
			while(list.empty() != true){
				double x = gen.nextDouble();
				if(x <= 0.2){
					Job j = new Job(x, count);
					add(j, type);
					count++;
				}
				else{
					pop(type);
					c2++;
					count++;
				}
			}
		}
		// last stage
		if(type == 1){
			while(stack.empty() != true){
				pop(type);
				c2++;
				count++;
			}
		}
		else if(type == 2){
			while(four_stack.empty() != true){
				pop(type);
				c2++;
				count++;
			}
		}
		else if(type == 3){
			while(list.empty() != true){
				pop(type);
				c2++;
				count++;
			}
		}
		else{
			while(heap.empty() != true){
				pop(type);
				c2++;
				count++;
			}
		}
		// the end execution time
		long end = System.currentTimeMillis();
		System.out.println("Run Time = " + (end - start) + " " + type2 + " Quality: " + (quality/c2));
		
		
		
	}
	// add function that adds the element job to the proper data structure
	public static void add(Job j, int type){
		if(type == 1){
			stack.add(j);
		}
		else if(type == 2){
			four_stack.add(j);
		}
		else if(type == 3){
			list.add(j);
		}
		else{
			heap.add(j);
		}
	}
	// pop method which pops and determines the quality sum which will later be averaged.
	public static void pop(int type){
		if(type == 1){
			Job stackOut = stack.pop();
			quality += stackOut.getPriority() * (count - stackOut.getCreationTime());
		}
		else if(type == 2){
			Job fStackOut = four_stack.pop();
			quality += fStackOut.getPriority() * (count - fStackOut.getCreationTime());
		}
		else if(type == 3){
			Job lListOut = list.pop();
			quality += lListOut.getPriority() * (count - lListOut.getCreationTime());
		}
		else{
			Job heapOut = heap.pop();
			quality += heapOut.getPriority() * (count - heapOut.getCreationTime());
		}
	}
	
}

