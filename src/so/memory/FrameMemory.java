package so.memory;

public class FrameMemory {
	private int pageNum;
	private int displacement;
	
	
	public FrameMemory(int pageNum, int displacement) {
		super();
		this.pageNum = pageNum;
		this.displacement = displacement;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
}
