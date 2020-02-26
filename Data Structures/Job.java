// job class
public class Job {
	private double priority;
	private double creationTime;
	private int JobName;
	// constructor s
	public Job(){
		priority = 0;
		creationTime = 0;
		
	}
	public Job(double priority){
		this.priority = priority;
	}
	public Job(double priority, int creationTime){
		this.priority = priority;
		this.creationTime = creationTime;
		this.JobName =   creationTime;
	}
	public double getPriority() {
		return priority;
	}
	public void setPriority(double priority) {
		this.priority = priority;
	}
	public double getCreationTime() {
		return creationTime;
	}
	public void setCreationTime() {
		this.creationTime++;
	}
	public int getJobName() {
		return JobName;
	}
	public void setJobName(int JobName) {
		this.JobName += JobName;
	}

	
	
	
	
}
