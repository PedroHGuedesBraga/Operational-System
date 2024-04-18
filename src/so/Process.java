package so;

import java.util.LinkedList;
import java.util.List;

public class Process {
	private String id;
	private int sizeInMemory;
	private List<String>subProcesses;
	public static int count;
	private int timeToExecute;
	private int priorityProcess;
	

	public Process(int size, int priority, int timeToExecute) {
		count++;
		this.id = "P"+ count;
		this.sizeInMemory = size;
		this.subProcesses = this.getSubProcesses();
		this.timeToExecute = timeToExecute;
		this.priorityProcess = priority;
	}
	
	
	public List<String> getSubProcesses() {
	    if (this.subProcesses == null || this.subProcesses.isEmpty()) {
	        this.subProcesses = new LinkedList<String>();
	        for (int i = 0; i < this.sizeInMemory; i++) {
	            String spId = this.getId() + i;
	            this.subProcesses.add(spId);
	        }
	    }
	    return this.subProcesses;
	}



	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSizeInMemory() {
		return sizeInMemory;
	}
	public void setSizeInMemory(int sizeInMemory) {
		this.sizeInMemory = sizeInMemory;
	}
	
	public int getTimeToExecute() {
		return timeToExecute;
	}
	public int getPriorityProcess() {
		return priorityProcess;
	}
	
	
	
	
}
