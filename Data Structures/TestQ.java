import java.util.LinkedList;
import java.util.Scanner;

public class TestQ {
	// global variables defined. we shall use these later on!!
	public static MyStack stack = new MyStack(new Job[100]);
	public static FourStacks four_stack = new FourStacks(new MyStack[4]);
	public static MyLinkedList list = new MyLinkedList();
	public static MaxHeap heap = new MaxHeap(100);
	public static int count = 0;
	public static int c1 = 0;
	public static int c2 = 0;
	public static int c3 = 0;
	public static int c4 = 0;
	public static double sum1 = 0;
	public static double sum2 = 0;
	public static double sum3 = 0;
	public static double sum4 = 0;
	// creates jobs and adds them using the add function of each structure.
	public static void CreateJob(String p){
		double priority = Double.parseDouble(p);
		Job x = new Job(priority, count);
		stack.add(x);
		four_stack.add(x);
		list.add(x);
		heap.add(x);
		System.out.println(" Creating J" + x.getJobName() + " priority:" + x.getPriority());
	}
	
	
	// pop method that pops and keeps the j name and the counts needed to calculate the delay and quality cost.
	public static void Pop(){
		if(stack.empty() == false){
		Job x = stack.pop();
		double DelayCost1 = x.getPriority()*(count - x.getCreationTime());
		c1++;
		sum1+= DelayCost1;
		System.out.printf(" Stack: Executing J" + x.getJobName() + ". Delay Cost "+ "%.2f",DelayCost1);	
		System.out.println();
		Job y = four_stack.pop();
		double DelayCost2 = y.getPriority() *(count - y.getCreationTime());
		c2++;
		sum2+= DelayCost2;
		System.out.printf(" Four Stack: Executing J"  + y.getJobName()  + ". Delay Cost "+ "%.2f",DelayCost2);
		System.out.println();
		Job z = list.pop();
		double DelayCost3 = z.getPriority() * (count - z.getCreationTime());
		c3++;
		sum3+= DelayCost3;
		System.out.printf(" Linked List: Executing J" +  z.getJobName() + ". Delay Cost " + "%.2f",DelayCost3);
		System.out.println();
		Job m = heap.pop();
		double DelayCost4 = m.getPriority() *(count - m.getCreationTime());
		c4++;
		sum4+= DelayCost4;
		System.out.printf(" Max Heap: Executing J" + m.getJobName()+ ". Delay Cost "+ "%.2f",DelayCost4);
		System.out.println();
		}
		
		else{
			double q1 = sum1 / c1;
			double q2 = sum2 / c2;
			double q3 = sum3 / c3;
			double q4 = sum4 / c4;
			System.out.printf("Quality: Stack: " + "%.2f",q1);
			System.out.printf(" Four Stacks: " +"%.2f", q2);
			System.out.printf(" LinkedList: " + "%.2f",q3);
			System.out.printf(" Max Heap: " +"%.2f", q4 );		
			}
		
	}
	// F method that is essentially just the pop function but in a while loop
	public static void F(){
		while(stack.getNumElements() != 0 ){
			Job x = stack.pop();
			double DelayCost1 = x.getPriority()*(count - x.getCreationTime());
			c1++;
			sum1 += DelayCost1;
			System.out.printf(" Stack: Executing J" + x.getJobName() + ". Delay Cost "+ "%.2f",DelayCost1);	
			System.out.println();
			Job y = four_stack.pop();
			double DelayCost2 = y.getPriority() *(count - y.getCreationTime());
			c2++;
			sum2 += DelayCost2;
			System.out.printf(" Four Stack: Executing J"  + y.getJobName()  + ". Delay Cost "+ "%.2f",DelayCost2);
			System.out.println();
			Job z = list.pop();
			double DelayCost3 = z.getPriority() * (count - z.getCreationTime());
			c3++;
			sum3 += DelayCost3;
			System.out.printf(" Linked List: Executing J" +  z.getJobName() + ". Delay Cost " + "%.2f",DelayCost3);
			System.out.println();
			Job m = heap.pop();
			double DelayCost4 = m.getPriority() *(count - m.getCreationTime());
			c4++;
			sum4 += DelayCost4;
			System.out.printf(" Max Heap: Executing J" + m.getJobName()+ ". Delay Cost "+ "%.2f",DelayCost4);
			System.out.println();
			System.out.println();
			count++;
		}
		double q1 = sum1 / c1;
		double q2 = sum2 / c2;
		double q3 = sum3 / c3;
		double q4 = sum4 / c4;
		System.out.printf("Quality: Stack: " + "%.2f",q1);
		System.out.printf(" Four Stacks: " +"%.2f", q2);
		System.out.printf(" LinkedList: " + "%.2f",q3);
		System.out.printf(" Max Heap: " +"%.2f", q4 );
	}
	
	// tester 
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		String line;
		String word;
		while(input.hasNextLine()){
			line = input.nextLine();
			Scanner input2 = new Scanner(line);
			while(input2.hasNext()){
				word = input2.next();
				switch(word.charAt(0)){
				case 'J':
					CreateJob(input2.next());
					count++;
                    break;	
				case 'E':
					Pop();
					count++;
					break;
				case 'F':
					F();
					break;
				}
				
					
			}
		}
		
	}
	
}
