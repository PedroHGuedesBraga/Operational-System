package so;

public class Execute {
    public static void main(String[] args) {
    	Process p1 = SystemOperation.SystemCall(SystemCallType.CREATE, null, "p1", 20);
        SystemOperation.SystemCall(SystemCallType.WRITE, p1, "p1", 0);       
        Process p2 = SystemOperation.SystemCall(SystemCallType.CREATE, null, "p2", 38);
        SystemOperation.SystemCall(SystemCallType.WRITE, p2, "p2", 0);
        Process p3 = SystemOperation.SystemCall(SystemCallType.CREATE, null, "p3", 38);
        SystemOperation.SystemCall(SystemCallType.WRITE, p3, "p3", 0);     
        Process p4 = SystemOperation.SystemCall(SystemCallType.CREATE, null, "p4", 20);
        SystemOperation.SystemCall(SystemCallType.WRITE, p4, "p4", 0);
        SystemOperation.SystemCall(SystemCallType.DELETE,p2, "p2", 0);
        Process p5 = SystemOperation.SystemCall(SystemCallType.CREATE, null, "p5", 30);
        SystemOperation.SystemCall(SystemCallType.WRITE, p5, "p5", 0);
   //     Process p6 = SystemOperation.SystemCall(SystemCallType.CREATE, null, "p6", 12);
   //     SystemOperation.SystemCall(SystemCallType.WRITE, p6, "p6", 0);
    }
}
