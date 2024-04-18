package so.memory;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import so.Process;
import so.SubProcess;

public class MemoryManager {
	private SubProcess[][] physicalMemory;
	private Hashtable<String, FrameMemory> logicalMemory;
	private int pageSize;
	private int memorySize;
	public static int NUM_OF_INSTRUCTIONS_PER_PROCESS = 7;

	public MemoryManager(int memorySize, int pageSize) {
		this.pageSize = pageSize;
		this.memorySize = memorySize;
		int pages = (int) Math.ceil(this.memorySize / this.pageSize);
		this.physicalMemory = new SubProcess[pages][this.pageSize];
		this.logicalMemory = new Hashtable<>();
	}

	public void write(Process p) {
		int emptyPagesLength = this.getEmptyFrame().size();
		double pageRequerid = (double) p.getSizeInMemory() / this.pageSize;
		
		if (pageRequerid > emptyPagesLength) {
		System.out.println("Page Fault");
		} else {
			
			this.writeUsingPaging(p);
		}
	}

	private void writeUsingPaging(Process p) {
		ArrayList<Integer> frames = this.getEmptyFrame();

		int count = 0;

		for (int i = 0; i < frames.size(); i++) {
			int indexFrame = frames.get(i);
			SubProcess[] page = this.physicalMemory[indexFrame];

			int indexPage = 0;

			while (indexPage < page.length && count < p.getSizeInMemory()) {
				String indexSubProcessId = p.getSubProcesses().get(count);

				this.physicalMemory[indexFrame][indexPage] = new SubProcess(indexSubProcessId, p);

				this.logicalMemory.put(indexSubProcessId, new FrameMemory(indexFrame, indexPage));

				count++;
				indexPage++;
			}

		}

		this.printStatusMemory(p);

	}

	private ArrayList<Integer> getEmptyFrame() {
		ArrayList<Integer> emptyFrames = new ArrayList<Integer>();

		if (this.physicalMemory != null) {
			for (int i = 0; i < physicalMemory.length; i++) {
				if (this.physicalMemory[i][0] == null) {
					emptyFrames.add(i);
				}
			}
		}

		return emptyFrames;
	}

	public void delete(Process p) {

	}

	private void printStatusMemory(Process p) {
		for (int i = 0; i < this.physicalMemory.length; i++) {
			for (int j = 0; j < this.physicalMemory[i].length; j++) {
				SubProcess sp = this.physicalMemory[i][j];
				String spId = null;
				if (sp != null) {
					spId = sp.getId();
				}
				if (j == this.physicalMemory[i].length - 1) {
					System.out.println(spId);
				} else {
					System.out.print(spId + " | ");
				}
			}
		}
	}

	public List<SubProcess> read(Process p) {
		List<String> ids = p.getSubProcesses();
		List<SubProcess> sps = new LinkedList<>();
		for (String id : ids) {
			FrameMemory fm = this.logicalMemory.get(id);
			
			if (fm != null) {
				
				sps.add(this.physicalMemory[fm.getPageNum()][fm.getOffset()]);
			}

		}
		return sps;
	}

}
