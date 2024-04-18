package so.schedule;

import java.util.LinkedList;
import java.util.List;

import so.Process;
import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;

public class Lotery extends Scheduler {
	private LinkedList<Process> processList;
	private LinkedList<SubProcess> subProcessList;

	public Lotery() {
		this.processList = new LinkedList<Process>();
		this.subProcessList = new LinkedList<SubProcess>();
	}

	public void addProcess(Process process) {
		this.processList.add(process);
	}

	public SubProcess execute() {
		randomFirstProcess();
		if (subProcessList != null) {

			SubProcess element = this.subProcessList.poll();

			if (element != null) {
				return element;
			}
		}
		return null;
	}

	private void randomFirstProcess() {
		if (processList != null && !processList.isEmpty()) {

			int randomIndex = (int) (Math.random() * this.processList.size());
			Process process = this.processList.get(randomIndex);

			if (process != null) {
				List<SubProcess> subProcesses = SystemOperation.SystemCall(SystemCallType.READ_PROCESS, process);

				for (SubProcess value : subProcesses) {
					this.subProcessList.add(value);
				}

				this.processList.removeIf(p -> p.getId() == process.getId());
			}
		}
	}

	@Override
	public void addProcessAndSubProcess(Process p) {
		this.processList.add(p);

	}

	@Override
	public void finish(so.Process p) {
		// TODO Auto-generated method stub

	}
}