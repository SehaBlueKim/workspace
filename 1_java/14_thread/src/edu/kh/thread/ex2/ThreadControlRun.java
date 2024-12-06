package edu.kh.thread.ex2;

public class ThreadControlRun {
	
	public static void main(String[] args) {
		
		Thread sleep = new Thread(new SleepThread1());
//		sleep.run();
		
		Thread myClock = new Thread(new MyClock());
//		myClock.run();
		
		InterruptTest it = new InterruptTest();
//		it.test();
		
		// stopWatch
		StopWatchController stopWatch = new StopWatchController();
		stopWatch.watchStart();
		
		
	}
}
