public class MaxHeap extends MyQueue{
	// global variables
	private Job[] maxheap;
	private int s;
	private int m;
	// this gives us the [1] as the max. 
	public static final int first = 1;
	// constructor
	public MaxHeap(int m){
		this.m = m;
		this.s = 0;
		maxheap = new Job[this.m + 1];
		Job x = new Job(Double.MAX_VALUE);
		maxheap[0] = x;
	}
	// method to return the parent
	public int parent(int pos){
		
		return pos / 2;
	}
	// method to return the left child
	public int leftChild(int p){
		return 2 * p;
	}
	// method to return right child
	public int rightChild(int p){
		return ((2 * p) + 1);
	}
	// check if it's a leaf
	public boolean isLeaf(int p){
		if(p-1 >= (s/2) && p-1<= s){
			return true;
		}
		else{
			return false;
		}
		
	}
	// all three methods get used in heapify which basically structures the job elements into a max heap
	public void Heapify(int p){
		if(!isLeaf(p)){
			if(maxheap[p].getPriority() < maxheap[leftChild(p)].getPriority() || maxheap[p].getPriority() < maxheap[rightChild(p)].getPriority()){
				if(maxheap[leftChild(p)].getPriority() > maxheap[rightChild(p)].getPriority()){	
					swap(p,leftChild(p));
					Heapify(leftChild(p));
				}
				else{
					swap(p, rightChild(p));
					Heapify(rightChild(p));
				}
				
				
				
			}
		}
		
	}
	// swap method used by heapify that exchanges job element positions
	public void swap(int x, int y){
		Job t;
		t = maxheap[x];
		maxheap[x] = maxheap[y];
		maxheap[y] = t;
		
	}
	
	@Override
	// add function that adds a job.
	public void add(Job j){
		maxheap[++s] = j;
		int c = s;
		while(maxheap[c].getPriority() > maxheap[parent(c)].getPriority()){
			swap(c,parent(c));
			c = parent(c);
			
		}
		
	}
	
	
	
	


	@Override
	// checks to see if it is empty.
	public boolean empty() {
		if(s <= 0){
			return true;
		}
		else{
		return false;
		}
	}

	@Override
	// pop method that removes the first aka max node. uses heapify to re-arrange everything.
	public Job pop() {
		Job j = maxheap[first];
		maxheap[first] = maxheap[s--];
		Heapify(first);
		return j;
		
	}

	
	
	
}
