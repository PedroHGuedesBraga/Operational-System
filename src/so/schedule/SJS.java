package so.schedule;

import java.util.Comparator;

import so.SubProcess;

public class SJS extends SchedulerQueue {

	public SJS(Comparator<SubProcess> comparator) {
		super(getComparator());
		// TODO Auto-generated constructor stub
	}
	private static Comparator<SubProcess> getComparator() {
		return new Comparator<SubProcess>() {
		
		@Override
		public int compare(SubProcess sp1, SubProcess sp2) {
			return sp1.getTimeToExeceute()>= sp2.getTimeToExeceute() ? -1 : 1;
		}
	};
} 
	@Override
	public void execute(Process p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish(Process p) {
		// TODO Auto-generated method stub
		
	}

}
