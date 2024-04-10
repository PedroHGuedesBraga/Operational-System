package so.schedule;

import java.util.Comparator;

import so.Process;
import so.SubProcess;

public class RoundRobin extends SchedulerQueue{
	private int quantum;
	public RoundRobin() {
		super(new Comparator<Process>() {
			
			@Override
			public int compare(Process p1, Process p2) {
				return 0;
			}
		});
		// TODO Auto-generated constructor stub
	}



}
