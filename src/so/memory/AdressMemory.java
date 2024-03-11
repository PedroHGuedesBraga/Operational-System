package so.memory;

public class AdressMemory {
	private int start;
	private int end;
	
	public AdressMemory(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getSize() {
		return (this.end - this.start) + 1;
	}
}
