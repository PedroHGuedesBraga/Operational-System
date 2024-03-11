package so.memory;
import so.Process;

public class MemoryManager {
	private String[] physicMemory;
	private Strategy strategy;
	public MemoryManager(Strategy strategy) {
		this.strategy = strategy;
		physicMemory = new String[128];
		
	}
	public void write(Process p) {
		if(this.strategy.equals(Strategy.FIRST_FIT)){
			this.WriteUsingFirstFit(p);
		}else if(this.strategy.equals(Strategy.BEST_FIT)){
			this.WriteUsingBestFit(p);
		}
		else if(this.strategy.equals(Strategy.WORST_FIT)){
			this.WriteUsingWorstFit(p);
		}
		else if(this.strategy.equals(Strategy.PAGING)){
			this.WriteUsingPaging(p);
		}
	}
	private void WriteUsingPaging(Process p) {
		// TODO Auto-generated method stub
		
	}
	private void WriteUsingWorstFit(Process p) {
		// TODO Auto-generated method stub
		
	}
	private void WriteUsingBestFit(Process p) {
		// TODO Auto-generated method stub
		
	}
	private void WriteUsingFirstFit(Process p) {
		int actualSize = 0;
		for(int i = 0; i < physicMemory.length; i++) {
			if(i == physicMemory.length - 1) {
			 if(actualSize >0) {
				 int start = i-actualSize ;
				 int end = i;
				 AdressMemory adress = new AdressMemory(start,end);
				 if(p.getSizeInMemory()<= adress.getSize()) {
				 	insertProcessInMemory(p,adress);
				 	break;
				 	}
			 }
			}
		    else if(physicMemory[i] == null) {
				actualSize++;
			}else {
				if(actualSize > 0) {
					int start = i - actualSize;
					int end = i ;
					AdressMemory adress = new AdressMemory(start,end);
					if(p.getSizeInMemory() <= adress.getSize()) {
						insertProcessInMemory(p,adress);
						break;
						
					}
				}
				actualSize = 0;
			}
			
		}
		printMemoryStatus();
	}
	private void printMemoryStatus() {
		for(int i = 0; i < physicMemory.length; i++) {
			System.out.print(physicMemory[i] + " / ");
			
		}
		
	}
	private void insertProcessInMemory(Process p, AdressMemory adress) {
		for (int i = adress.getStart(); i<= adress.getEnd(); i++) {
			this.physicMemory[i] = p.getId();
		}
		
	}
	public void delete(Process p) {
		
	}

}
