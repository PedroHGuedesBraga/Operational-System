package so;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import so.memory.AdressMemory;

public class Process {
	private String id;
	private int sizeInMemory;
	private List<String>subProcesses;
	public static int count;
	//private int timeToExecution;
	//private AdressMemory adressInMemory;
	
	public Process(int size) {
		count++;
		this.id = "P"+ count;
		this.sizeInMemory = size;
		this.subProcesses = this.getSubProcesses();
	}
	
	
	public List<String> getSubProcesses() {
		if(this.subProcesses == null|| this.subProcesses.isEmpty()) {
			this.subProcesses = new LinkedList<String>();
			for(int i = 0; i<this.sizeInMemory; i++) {
				//GAMBIARRA
				String spId = this.getId() + i; 
			this.subProcesses.add(spId);
			}	
		} return this.subProcesses;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSizeInMemory() {
		return sizeInMemory;
	}
	public void setSizeInMemory(int sizeInMemory) {
		this.sizeInMemory = sizeInMemory;
	}
	
	
	
	
}
