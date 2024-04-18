package so.schedule;

import java.util.Comparator;
import java.util.List;

import so.Process;
import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;

public class Priority extends SchedulerQueue {

	public Priority() {
		super(new Comparator<Process>() {

			@Override
			public int compare(Process p1, Process p2) {
				return p2.getPriorityProcess() - p1.getPriorityProcess();
			}
		});
	}

	public void addProcessAndSubProcess(Process p) {

		this.queue.add(p);

	}

	@Override
	public SubProcess execute() {
		this.orderListByPriority();

		if (this.queue != null) {

			if (this.subProcesses != null) {
				return this.subProcesses.poll();
			}
		}

		return null;
	}

	private void orderListByPriority() {
		if (this.queue != null) {

			Process process = this.queue.poll();

			if (process != null) {
				List<SubProcess> subProcesses = SystemOperation.SystemCall(SystemCallType.READ_PROCESS, process);

				for (SubProcess value : subProcesses) {
					this.subProcesses.add(value);
				}
			}
		}
	}

}
