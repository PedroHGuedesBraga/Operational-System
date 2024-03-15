package so;

public class Execute {
	public static void main(String[] args) {
	
		 Process p1 = SystemOperation.SystemCall(SystemCallType.CREATE, null);
		 SystemOperation.SystemCall(SystemCallType.WRITE, p1);
		 Process p2 = SystemOperation.SystemCall(SystemCallType.CREATE, null);
		 SystemOperation.SystemCall(SystemCallType.WRITE, p2);
		 Process p3 = SystemOperation.SystemCall(SystemCallType.CREATE, null);
		 SystemOperation.SystemCall(SystemCallType.WRITE, p3);
		 Process p4 = SystemOperation.SystemCall(SystemCallType.CREATE, null);
		 SystemOperation.SystemCall(SystemCallType.WRITE, p4);
		 Process p5 = SystemOperation.SystemCall(SystemCallType.CREATE, null);
		 SystemOperation.SystemCall(SystemCallType.WRITE, p5);
}
}
