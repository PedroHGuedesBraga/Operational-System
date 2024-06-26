package so.cpu;

import so.SubProcess;

public class Core implements Runnable  {
	private SubProcess actuallyProcess;
	private int numOfInstructions;
	int count;
	private int id;
	
	
	public Core(int numOfInstructions, int id) {//7
		this.numOfInstructions = numOfInstructions;
		this.id = id; 
	}
	@Override
	public void run() {
		count += numOfInstructions;
		if(count>= actuallyProcess.getInstructions()) {
			
			if (this.actuallyProcess != null) {
				
				System.out.println(this.actuallyProcess.getId());
			}
			this.finish();
		}
	}
	private void finish() {
		this.actuallyProcess = null;
		this.count = 0;
		
		
	}

	public SubProcess getActuallyProcess() {
		return actuallyProcess;
	}
	
	public void setActuallyProcess(SubProcess actuallyProcess) {
		this.actuallyProcess = actuallyProcess;
	}
	
	public int getId() {
		return id;
	}
		
	
}
