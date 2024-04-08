package so;

public class SubProcess {
	private String processId;
	private String id;
	private int instructions;
	public static int count;
	
	public SubProcess(String processId,int instructions){
		this.processId = processId;
		this.id = processId+count++;
		this.instructions = instructions;
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
	
}
