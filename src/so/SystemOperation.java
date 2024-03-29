package so;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.schedule.Schedule;

public class SystemOperation {
    private static MemoryManager mm;
    private static CpuManager cm;
    private static Schedule schedule;

    public static MemoryManager getMm() {
        return mm;
    }

    public static void setMm(MemoryManager mm) {
        SystemOperation.mm = mm;
    }

    public static CpuManager getCm() {
        return cm;
    }

    public static void setCm(CpuManager cm) {
        SystemOperation.cm = cm;
    }

    public static Schedule getSchedule() {
        return schedule;
    }

    public static void setSchedule(Schedule schedule) {
        SystemOperation.schedule = schedule;
    }

    public static Process SystemCall(SystemCallType type, Process p, String id, int sizeInMemory) {
        if (type.equals(SystemCallType.WRITE)) {
            mm.write(p);

        } else if (type.equals(SystemCallType.READ)) {

        } else if (type.equals(SystemCallType.DELETE)) {
            mm.delete(p);
        } else if (type.equals(SystemCallType.CREATE)) {
            if (cm == null) {
                cm = new CpuManager();
            }
            if (mm == null) {
                mm = new MemoryManager(Strategy.PAGING);
            }
            return new Process(id, sizeInMemory);
        }
        return null;
    }
}
