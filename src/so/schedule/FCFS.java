package so.schedule;

import java.util.Comparator;
import java.util.List;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.Process;
public class FCFS extends SchedulerQueue{

	public FCFS() {
		super(getComparator()); // TODO Auto-generated constructor stub
	}

	private static Comparator<SubProcess> getComparator() {
			return new Comparator<SubProcess>() {
			
			@Override
			public int compare(SubProcess sp1, SubProcess sp2) {
				return -1;
			}
		};
	}

	@Override
	public void execute(Process p) {
		List<SubProcess> processes = SystemOperation.SystemCall(SystemCallType.READ_PROCESS, p);
	}

	@Override
	public void finish(Process p) {
		// TODO Auto-generated method stub
		
	} 

}
