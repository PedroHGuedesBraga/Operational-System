package so.schedule;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import so.Process;
import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;

public abstract class SchedulerQueue extends Scheduler {
	protected PriorityQueue<Process> queue;
	protected LinkedList<SubProcess> subProcesses;

	public SchedulerQueue(Comparator<Process> comparator) {
		this.queue = new PriorityQueue<>(comparator);
		this.subProcesses = new LinkedList<>();
	}

	@Override
	public void finish(Process p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addProcessAndSubProcess(Process p) {
		if (this.queue != null) {
			this.queue.add(p);

			List<SubProcess> sps = SystemOperation.SystemCall(SystemCallType.READ_PROCESS, p);

			if (this.subProcesses != null) {
				for (SubProcess subProcess : sps) {
					this.subProcesses.add(subProcess);
				}
			}

		}

	}
}
