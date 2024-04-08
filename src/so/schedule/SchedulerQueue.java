package so.schedule;
import so.SubProcess;

import java.util.Comparator;
import java.util.PriorityQueue;

public abstract class SchedulerQueue extends Scheduler {
	private PriorityQueue <SubProcess> subProcesses;
	
	public SchedulerQueue(Comparator<SubProcess> comparator) {
		this.subProcesses = new PriorityQueue<>(comparator);
	}
	
	public PriorityQueue<SubProcess> getSubProcesses() {
		return subProcesses;
	}

	public void setSubProcesses(PriorityQueue<SubProcess> subProcesses) {
		this.subProcesses = subProcesses;
	} 
}
