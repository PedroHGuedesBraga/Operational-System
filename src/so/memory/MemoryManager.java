package so.memory;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import so.Process;
import so.SystemOperation;

public class MemoryManager {
	private String[] physicalMemory;
	private Hashtable <String,List<FrameMemory>> logicalMemory;
	private Strategy strategy;
	private int pageSize;

	public MemoryManager(Strategy strategy) {
		this.pageSize =2;
		this.strategy = strategy;
		physicalMemory = new String[128];
		this.logicalMemory = new Hashtable<>();
	}
	//Sobrecarga de construtores 9:57 paginação parte II  
	public MemoryManager(Strategy strategy, int pageSize) {
		this(strategy);
		this.pageSize = pageSize;
		
		
	}

	public void write(Process p) {
		if (this.strategy.equals(Strategy.FIRST_FIT)) {
			this.writeUsingFirstFit(p);
		} else if (this.strategy.equals(Strategy.BEST_FIT)) {
			this.writeUsingBestFit(p);
		} else if (this.strategy.equals(Strategy.WORST_FIT)) {
			this.writeUsingWorstFit(p);
		} else if (this.strategy.equals(Strategy.PAGING)) {
			this.writeUsingPaging(p);
		}
	}

	private void writeUsingPaging(Process p) {
		List<FrameMemory> frames = this.getFrames(p);
		for(int i = 0; i< frames.size(); i++) {
			FrameMemory actuallyFrame = frames.get(i);
			for(int j = actuallyFrame.getPageNum();j<actuallyFrame.getDisplacement(); j++  ) {
				this.physicalMemory[j] = p.getId();
				
			}
			
		}
		this.logicalMemory.put(p.getId(), frames);
	}
	
	private List<FrameMemory> getFrames(Process p){
		int processSize= 0;
		List<FrameMemory> frames = new ArrayList<>();
		for (int page = 0; page < this.physicalMemory.length;page+= this.pageSize) {
			if(this.physicalMemory[page] == null) {
				frames.add(new FrameMemory(page,this.pageSize));
				processSize+= this.pageSize;
				int spaceInPages = (frames.size() * this.pageSize);
				
				if(processSize <= spaceInPages) {
					return frames;
				}
			}
		}
		return null;
	}
	//NO video ele pos como private void, porém ele da erro no System call Type, pois o metodo não fica acessivel, pus ele como public.
	public void delete(Process p) {
		List<FrameMemory> frames = this.logicalMemory.get(p.getId());
		for(int i = 0; i< frames.size(); i++) {
			FrameMemory actuallyFrame = frames.get(i);
			for(int j = actuallyFrame.getPageNum();j<actuallyFrame.getDisplacement(); j++  ) {
				this.physicalMemory[j] = null;
				
			}
		}
		
		
	}

	private void writeUsingBestFit(Process p) {
		
	}

	private void writeUsingWorstFit(Process p) { }
		

	private void writeUsingFirstFit(Process p) {

	}

	/*private void printMemoryStatus() {
		for (int i = 0; i < physicalMemory.length; i++) {
			System.out.print(physicalMemory[i] + " / ");
		}
	}/*

	/*private void insertProcessInMemory(Process p, AdressMemory adress) {
		int size = p.getSizeInMemory();
		int start = adress.getStart();
		int end = start + size;

		for (int i = start; i < end; i++) {
			if (size > 0) {
				this.physicalMemory[i] = p.getId();
				size--;
			} else {
				break;
			}
		}
	}*/

	
}
