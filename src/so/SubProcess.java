package so;

public class SubProcess {
	private String id;
	private Process process;
	private int instructions;
	public static int count;
	
	
	public SubProcess(String id, Process process){
		this.id = id;
		this.process = process;
		this.instructions = 7;
		
		
		count++;
	}
	public Process getProcessId() {
		return this.process;
	}
	public void setProcessId(Process processId) {
		this.process = processId;
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
	

	
}
