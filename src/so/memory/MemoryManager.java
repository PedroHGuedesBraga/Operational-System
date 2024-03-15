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
	
	private void WriteUsingBestFit(Process p) {
	    int bestFitStart = -1; // Índice de início do melhor ajuste encontrado
	    int bestFitEnd = -1;   // Índice de fim do melhor ajuste encontrado
	    int bestFitSize = Integer.MAX_VALUE; // Tamanho do melhor ajuste encontrado

	    int currentStart = -1; // Índice de início do bloco de memória atualmente em análise
	    int currentSize = 0;   // Tamanho do bloco de memória atualmente em análise

	    // Iterar sobre todo o array de memória física
	    for (int i = 0; i < physicMemory.length; i++) {
	        // Verificar se a posição atual está vazia
	        if (physicMemory[i] == null) {
	            // Se a posição atual estiver vazia, incrementamos o tamanho do bloco atual
	            if (currentStart == -1) {
	                // Atualizamos o início do bloco
	                currentStart = i;
	            }
	            // Incrementar o tamanho do bloco
	            currentSize++;
	        } else {
	            // Verificar se o bloco atual é um melhor ajuste
	            if (currentSize >= p.getSizeInMemory() && currentSize < bestFitSize) {
	                // Atualizar o melhor ajuste encontrado até agora
	                bestFitStart = currentStart;
	                bestFitEnd = i - 1;
	                bestFitSize = currentSize;
	            }
	            // Resetar as variáveis para procurar um novo bloco livre
	            currentStart = -1;
	            currentSize = 0;
	        }
	    }

	    // Verificar se o último bloco é um melhor ajuste
	    if (currentStart != -1 && currentSize < bestFitSize) {
	        bestFitStart = currentStart;
	        bestFitEnd = physicMemory.length - 1;
	        bestFitSize = currentSize;
	    }

	    // Após a iteração, o melhor ajuste foi encontrado.
	    // Verificar se há espaço adequado para o processo
	    if (bestFitStart != -1 && bestFitSize >= p.getSizeInMemory()) {
	        // Se o tamanho do melhor ajuste for maior ou igual ao tamanho do processo,
	        // encontramos um espaço adequado.
	        AdressMemory address = new AdressMemory(bestFitStart, bestFitEnd);
	        insertProcessInMemory(p, address);
	    } else {
	        // Se não houver espaço adequado, imprime uma mensagem de erro
	        System.out.println("Não há espaço suficiente para o processo " + p.getId());
	    }

	    // Agora podemos atualizar o status da memória
	    printMemoryStatus();
	}

	private void WriteUsingWorstFit(Process p) {
	    int worstFitStart = -1; // Índice de início do pior ajuste encontrado
	    int worstFitEnd = -1;   // Índice de fim do pior ajuste encontrado
	    int worstFitSize = -1;  // Tamanho do pior ajuste encontrado

	    int currentStart = -1; // Índice de início do bloco de memória atualmente em análise
	    int currentSize = 0;   // Tamanho do bloco de memória atualmente em análise

	    // Iterar sobre todo o array de memória física
	    for (int i = 0; i < physicMemory.length; i++) {
	        // Verificar se a posição atual está vazia
	        if (physicMemory[i] == null) {
	            // Se a posição atual estiver vazia, incrementamos o tamanho do bloco atual
	            if (currentStart == -1) {
	                // Atualizamos o início do bloco
	                currentStart = i;
	            }
	            // Incrementar o tamanho do bloco
	            currentSize++;
	        } else {
	            // Verificar se o bloco atual é o pior ajuste
	            if (currentStart != -1) {
	                // Atualizar o pior ajuste encontrado até agora
	                if (currentSize > worstFitSize) {
	                    worstFitStart = currentStart;
	                    worstFitEnd = i - 1;
	                    worstFitSize = currentSize;
	                }
	                // Resetar as variáveis para procurar um novo bloco livre
	                currentStart = -1;
	                currentSize = 0;
	            }
	        }
	    }

	    // Verificar se o último bloco é o pior ajuste
	    if (currentStart != -1 && currentSize > worstFitSize) {
	        worstFitStart = currentStart;
	        worstFitEnd = physicMemory.length - 1;
	        worstFitSize = currentSize;
	    }

	    // Após a iteração, o pior ajuste foi encontrado.
	    // Verificar se há espaço adequado para o processo
	    if (worstFitStart != -1 && worstFitSize >= p.getSizeInMemory()) {
	        // Se o tamanho do pior ajuste for maior ou igual ao tamanho do processo,
	        // encontramos um espaço adequado.
	        AdressMemory address = new AdressMemory(worstFitStart, worstFitEnd);
	        insertProcessInMemory(p, address);
	    } else {
	        // Se não houver espaço adequado, imprime uma mensagem de erro
	        System.out.println("Não há espaço suficiente para o processo " + p.getId());
	    }

	    // Agora podemos atualizar o status da memória
	    printMemoryStatus();
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
	    int size = p.getSizeInMemory();
	    int start = adress.getStart();
	    int end = adress.getEnd();
	    
	    for (int i = start; i <= end; i++) {
	        // Verifica se o processo cabe na memória restante
	        if (size > 0) {
	            this.physicMemory[i] = p.getId();
	            size--;
	        } else {
	            break; 
	        }
	    }
	}


	public void delete(Process p) {
		
	}

}
