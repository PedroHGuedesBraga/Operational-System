package so.memory;

public class MemoryManager {
	private Strategy strategy;
	public MemoryManager(Strategy strategy) {
		this.strategy = strategy;
		
	}
	public void write(Process p) {
		if(this.strategy.equals(Strategy.FIRST_FIT)) {
			this.writeUsingFirstFit(Process p);
		}
		else if(this.strategy.equals(Strategy.WORST_FIT)) {
			this.writeUsingWorstFit(Process p);
		}
		else if(this.strategy.equals(Strategy.BEST_FIT)) {
			this.writeUsingBestFit(Process p);
		}
	}

}
