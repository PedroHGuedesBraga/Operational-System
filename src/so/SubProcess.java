package so;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SubProcess {
	private String processId;
	private String id;
	private int instructions;
	private int timeToExeceute;
	public static int count;
	private ProcessPriority priorityProcess;
	
	
	public SubProcess(String processId,int instructions){
		this.processId = processId;
		this.id = processId+count++;
		this.instructions = instructions;
		Random rand = new Random();
		List<Integer>givenList = Arrays.asList(100,200,300,400,500,600,700,800,900,1000,2000);
		this.timeToExeceute = givenList.get(rand.nextInt(givenList.size()));
		
		List<ProcessPriority>priorityList = Arrays.asList(ProcessPriority.BAIXA,ProcessPriority.MEDIA,ProcessPriority.ALTA,ProcessPriority.ALTISSIMA);
		this.priorityProcess = priorityList.get(rand.nextInt(priorityList.size()));
		
		count++;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getInstructions() {
		return instructions;
	}
	public void setInstructions(int instructions) {
		this.instructions = instructions;
	}
	public int getTimeToExeceute() {
		return timeToExeceute;
	}
	public ProcessPriority getPriorityProcess() {
		return priorityProcess;
	}
	
	
}
