package so.schedule;
import so.Process;
import java.util.Comparator;

import so.SubProcess;

public class SJF extends SchedulerQueue {

	public SJF() {
		super(getComparator());
		// TODO Auto-generated constructor stub
	}
	private static Comparator<Process> getComparator() {
		return new Comparator<Process>() {
		
		@Override
		public int compare(Process p1, Process p2) {
			return p1.getTimeToExeceute()< p2.getTimeToExeceute() ? 1 : -1;
		}
	};
} 


}
