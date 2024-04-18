package so;

public class Execute {
	public static void main(String[] args) {
		System.out.println("************************ Processo 1 ************************");
		Process p1 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, 130, 1, 10);
		SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p1);
		System.out.println("************************ Processo 2 ************************");
		Process p2 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, 90, 2, 5);
		SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p2);
		System.out.println("************************ Processo 3 ************************");
		Process p3 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, 30, 3, 15);
		SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p3);
	/*	System.out.println("************************ Processo 4 ************************");
		Process p4 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, 30, 3, 15);
		SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p4);
		System.out.println("************************ Processo 5 ************************");
		Process p5 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, 30, 3, 15);
		SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p5);
		*/
	}
}
