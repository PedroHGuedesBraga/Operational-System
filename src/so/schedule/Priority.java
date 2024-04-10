package so.schedule;
import java.util.Comparator;
import so.Process;
import so.SubProcess;
public class Priority extends SchedulerQueue {
	public Priority() {
		super(new Comparator<Process>() {
			
			@Override
			public int compare(Process p1, Process p2) {
				return p1.getPriorityProcess().getLevel() <=
						 p2.getPriorityProcess().getLevel() ? -1 : 1;
			}
		});
	}

}
