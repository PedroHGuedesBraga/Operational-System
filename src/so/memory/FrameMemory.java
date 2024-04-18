package so.memory;

public class FrameMemory {
	private int pageNum ;
	private int offset ;
	
	
	public FrameMemory(int pageNum, int offset) {
		super();
		this.pageNum = pageNum;
		this.offset = offset;
	}
	public FrameMemory(int pageNum) {
		this(pageNum, 0);
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
}
