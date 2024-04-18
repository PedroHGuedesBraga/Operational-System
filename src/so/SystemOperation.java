package so;

import java.util.List;

import so.memory.MemoryManager;
import so.schedule.FCFS;
import so.schedule.Lotery;
import so.schedule.Priority;
import so.schedule.SJF;
import so.schedule.Scheduler;

public class SystemOperation {
	private static MemoryManager mm;
	private static Scheduler scheduler;
	public static int PAGE_SIZE = 4;
	public static int MEMORY_SIZE = 256;

	
	public static Process SystemCall(SystemCallType type, int processSize, int priority, int timeToExecute) {
		if (type.equals(SystemCallType.CREATE_PROCESS)) {
			if (scheduler == null) {
				scheduler = new Lotery();
			}
			if (mm == null) {
				mm = new MemoryManager(MEMORY_SIZE, PAGE_SIZE);
			}
			return new Process(processSize, priority, timeToExecute);
		}
		return null;

	}

	public static List<SubProcess> SystemCall(SystemCallType type, Process p) {
		if (type.equals(SystemCallType.WRITE_PROCESS)) {
			mm.write(p);
			scheduler.addProcessAndSubProcess(p);

		} else if (type.equals(SystemCallType.DELETE_PROCESS)) {
			mm.delete(p);
			scheduler.finish(p);
		} else if (type.equals(SystemCallType.READ_PROCESS)) {
			return mm.read(p);
		}
		return null;
	}
}
