package so.cpu;

import java.util.Timer;
import java.util.TimerTask;

import so.SubProcess;
import so.schedule.Scheduler;

public class CpuManager {
	private Core[] cores;
	public static int NUM_OF_CORES = 4;
	public static int NUM_OF_INSTRUCTIONS = 7;
	public static int CLOCK = 500;
	private Scheduler scheduler;

	public CpuManager(Scheduler scheduler) {
		this.cores = new Core[NUM_OF_CORES];
		for (int i = 0; i < this.cores.length; i++) {
			this.cores[i] = new Core(NUM_OF_INSTRUCTIONS, i);
		}
		this.scheduler = scheduler;
		clock();
	}

	public void registerProcess(int coreId, SubProcess sp) {
		this.cores[coreId].setActuallyProcess(sp);

	}

	public void clock() {
		new Timer().scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				System.out.println("*****INICIANDO A EXECUÇÃO*********");
				executeProcess();

			}

		}, 0, CLOCK);

	}

	private void executeProcess() {
		for (Core core : this.cores) {
			if (this.scheduler != null) {
				
				SubProcess sp = this.scheduler.execute();
				
				if (sp != null) {					
					if (core.getActuallyProcess() == null) {
						core.setActuallyProcess(sp);
						core.run();
					}
				}
			}
		}

	}

	public Core[] getCores() {
		return cores;
	}

}
