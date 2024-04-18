package so.schedule;

import so.Process;
import so.SubProcess;
import so.cpu.CpuManager;

public abstract class Scheduler {
	private CpuManager cpu;
	
	public Scheduler() {
		this.cpu = new CpuManager(this);
	}
	
	public CpuManager getCpu() {
		return cpu;
	}
	
	public abstract void addProcessAndSubProcess(Process p);
	public abstract SubProcess execute();
	public abstract void finish(Process p);
}
