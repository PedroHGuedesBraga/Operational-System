package so.schedule;

import java.util.Comparator;
import java.util.List;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.Process;

public class FCFS extends SchedulerQueue{

	public FCFS() {
		super(new Comparator<Process>() {
			
			@Override
			public int compare(Process sp1, Process sp2) {
				return -1;
			}
		}); // TODO Auto-generated constructor stub
	}


	
	

}
