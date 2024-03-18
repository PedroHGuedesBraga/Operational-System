package so.memory;

import so.Process;
import so.SystemOperation;

public class MemoryManager {
	private String[] physicMemory;
	private Strategy strategy;

	public MemoryManager(Strategy strategy) {
		this.strategy = strategy;
		physicMemory = new String[128];
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
		// TODO Auto-generated method stub
	}

	private void writeUsingBestFit(Process p) {
		int bestFitStart = -1;
		int bestFitEnd = -1;
		int bestFitSize = Integer.MAX_VALUE;

		int currentStart = -1;
		int currentSize = 0;

		for (int i = 0; i < physicMemory.length; i++) {
			if (physicMemory[i] == null) {
				if (currentStart == -1) {
					currentStart = i;
				}
				currentSize++;
			} else {
				if (currentSize >= p.getSizeInMemory() && currentSize < bestFitSize) {
					bestFitStart = currentStart;
					bestFitEnd = i - 1;
					bestFitSize = currentSize;
				}
				currentStart = -1;
				currentSize = 0;
			}
		}

		if (currentSize >= p.getSizeInMemory() && currentSize < bestFitSize) {
			bestFitStart = currentStart;
			bestFitEnd = physicMemory.length - 1;
			bestFitSize = currentSize;
		}

		if (bestFitStart != -1 && bestFitSize >= p.getSizeInMemory()) {
			AdressMemory address = new AdressMemory(bestFitStart, bestFitEnd);
			insertProcessInMemory(p, address);
		} else {
			System.out.println("Não há espaço suficiente para o processo " + p.getId());
		}

		printMemoryStatus();
		System.out.println();
	}

	private void writeUsingWorstFit(Process p) {
		int worstFitStart = -1;
		int worstFitEnd = -1;
		int worstFitSize = -1;

		int currentStart = -1;
		int currentSize = 0;

		for (int i = 0; i < physicMemory.length; i++) {
			if (physicMemory[i] == null) {
				if (currentStart == -1) {
					currentStart = i;
				}
				currentSize++;
			} else {
				if (currentStart != -1) {
					if (currentSize > worstFitSize) {
						worstFitStart = currentStart;
						worstFitEnd = i - 1;
						worstFitSize = currentSize;
					}
					currentStart = -1;
					currentSize = 0;
				}
			}
		}

		if (currentStart != -1 && currentSize > worstFitSize) {
			worstFitStart = currentStart;
			worstFitEnd = physicMemory.length - 1;
			worstFitSize = currentSize;
		}

		if (worstFitStart != -1 && worstFitSize >= p.getSizeInMemory()) {
			AdressMemory address = new AdressMemory(worstFitStart, worstFitEnd);
			insertProcessInMemory(p, address);
		} else {
			System.out.println("Não há espaço suficiente para o processo " + p.getId());
		}

		printMemoryStatus();
		System.out.println();
	}

	private void writeUsingFirstFit(Process p) {
		int actualSize = 0;
		for (int i = 0; i < physicMemory.length; i++) {
			if (i == physicMemory.length - 1) {
				if (actualSize > 0) {
					int start = i - actualSize;
					int end = i;
					AdressMemory adress = new AdressMemory(start, end);
					if (p.getSizeInMemory() <= adress.getSize()) {
						insertProcessInMemory(p, adress);
					}
				}
			} else if (physicMemory[i] == null) {
				actualSize++;
			} else {
				if (actualSize > 0) {
					int start = i - actualSize;
					int end = i;
					AdressMemory adress = new AdressMemory(start, end);
					if (p.getSizeInMemory() <= adress.getSize()) {
						insertProcessInMemory(p, adress);
						break;
					} else {
						System.out.println("Não há espaço suficiente para o processo " + p.getId());
					}
				}
				actualSize = 0;
			}
		}

		printMemoryStatus();
		System.out.println();

	}

	private void printMemoryStatus() {
		for (int i = 0; i < physicMemory.length; i++) {
			System.out.print(physicMemory[i] + " / ");
		}
	}

	private void insertProcessInMemory(Process p, AdressMemory adress) {
		int size = p.getSizeInMemory();
		int start = adress.getStart();
		int end = start + size;

		for (int i = start; i < end; i++) {
			if (size > 0) {
				this.physicMemory[i] = p.getId();
				size--;
			} else {
				break;
			}
		}
	}

	public void delete(Process p) {
		for (int i = 0; i < physicMemory.length; i++) {
			if (physicMemory[i] != null && physicMemory[i].equals(p.getId())) {
				physicMemory[i] = null;
			}
		}
	}
}
