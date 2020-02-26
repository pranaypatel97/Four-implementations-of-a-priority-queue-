import java.util.*;
// for linked list, i used the java implementation 
public class MyLinkedList extends MyQueue{
	LinkedList<Job> list;

	
	public MyLinkedList(){
		list = new LinkedList<Job>();
	}
	
	@Override
	// regular add function
	public void add(Job j) {
		list.addFirst(j);
	}

	@Override
	public boolean empty() {
		return list.isEmpty();
	}

	@Override
	// pop function determines max element via iteration and removes it using the remove function
	public Job pop() {
		Job x = new Job(0);
		int p = 0;
		for(int i =0; i< list.size(); i++){
			if(list.get(i).getPriority() > x.getPriority()){
			x = list.get(i);
			p = i;
			}
		}
		list.remove(p);
		return x;
	}
	
	
	
	
}