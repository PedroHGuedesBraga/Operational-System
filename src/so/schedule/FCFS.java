package so.schedule;

import java.util.Comparator;

import so.Process;
import so.SubProcess;

public class FCFS extends SchedulerQueue {

	public FCFS() {
		super(new Comparator<Process>() {

			@Override
			public int compare(Process p1, Process p2) {
				return p2.getPriorityProcess() - p1.getPriorityProcess();
			}
		});
	}

	@Override
	public SubProcess execute() {
		if (this.queue != null) {

			if (this.subProcesses != null) {
				return this.subProcesses.poll();
			}
		}

		return null;
	}

}
