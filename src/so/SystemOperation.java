package so;

import java.util.List;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.schedule.FCFS;
import so.schedule.Scheduler;

public class SystemOperation {
    private static MemoryManager mm;
    private static CpuManager cm;
    private static Scheduler scheduler;
    public static int PAGE_SIZE = 4;
    public static int MEMORY_SIZE = 256;

    public static Process SystemCall(SystemCallType type,int processSize) {
    	 if (type.equals(SystemCallType.CREATE_PROCESS)) {
    	if (scheduler == null) {
    		scheduler = new FCFS();
            }
            if (mm == null) {
            	
                mm = new MemoryManager(MEMORY_SIZE,PAGE_SIZE);
            }	 
            return new Process(processSize); 
    	 }
    	 return null;
           
        }

    public static List<SubProcess> SystemCall(SystemCallType type, Process p) {
        if (type.equals(SystemCallType.WRITE_PROCESS)) {
            mm.write(p);
            scheduler.execute(p);

        } else if (type.equals(SystemCallType.DELETE_PROCESS)) {
            mm.delete(p);
            scheduler.finish(p);
        } else if(type.equals(SystemCallType.READ_PROCESS)) {
        	return mm.read(p);
        }
        return null;
    }
}
