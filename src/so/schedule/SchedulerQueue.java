package so.schedule;
import so.Process;
import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.cpu.Core;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

public  class SchedulerQueue extends Scheduler {
	private PriorityQueue <Process> queue;
	private Hashtable<String, List<SubProcess>> subProcesses;
	public SchedulerQueue(Comparator<Process> comparator) {
		this.queue = new PriorityQueue<>(comparator);
	}
	
	public PriorityQueue<Process> getQueue() {
		return queue;
	}

	@Override
	public void execute(Process p) {
		List<SubProcess> sps = SystemOperation.SystemCall(SystemCallType.READ_PROCESS,p);
		this.queue.add(p);
		this.subProcesses.put(p.getId(), sps);
		this.registerProcess();
	}

	private void registerProcess() {
		Process p = this.queue.poll();
		if(p != null) {
			List<SubProcess> sps = this.subProcesses.get(p.getId());
			Core[] cores = this.getCpu().getCores();
			for(Core core: cores) {
				if(core.getActuallyProcess() == null ) {
					SubProcess sp = sps.remove(sps.size() -1 );
					this.getCpu().registerProcess(core.getId(), sp);
				}
			}
		}
		
		
	}

	@Override
	public void finish(Process p) {
		// TODO Auto-generated method stub
		
	} 
}
