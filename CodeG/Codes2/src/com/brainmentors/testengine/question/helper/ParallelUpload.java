package com.brainmentors.testengine.question.helper;
class Logic{
	static int x ;
	  static void show(){
		  System.out.println("NOt Synch "+Thread.currentThread().getName());
		 // synchronized(this){
		for(int i = 1; i<=5; i++,x++){
			System.out.println("X is "+x+"   File Upload..."+i+" Name "+Thread.currentThread().getName());
			//System.out.println(Thread.currentThread().isAlive());
			try {
				//Thread.yield();
				//Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 // }
	}
}
class Job2 extends Thread{
	public void run(){
		for(int i = 1; i<=5; i++){
			System.out.println("JOB2..."+(i*2)+" Name "+Thread.currentThread().getName());
		}
	}
}

public class ParallelUpload implements Runnable {
	Logic logic= new Logic();
	@Override
	public void run(){
//		synchronized (logic) {
//			logic.show();
//		}
		synchronized (Logic.class) {
			Logic.show();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		StringBuilder sb = new StringBuilder();
		synchronized (sb) {
			sb.append("Hello");
		}
		sb.append("gfhjdf");
		ParallelUpload job = new ParallelUpload();
		Thread worker = new Thread(job,"ram");
		//worker.setPriority(Thread.MAX_PRIORITY);
		//Job2 job2 = new Job2();
		//job2.start();
		Thread worker2 = new Thread(job,"shyam");
		Thread worker3 = new Thread(job,"sohan");
		//worker2.setDaemon(true);
		//worker2.setPriority(Thread.MIN_PRIORITY);
		worker.start();
		//worker.join(millis);
		//worker.checkAccess();
		//worker.stop();
		//worker.join();
		worker2.start();
		worker3.start();
		
//		System.out.println("Main Thread "+Thread.currentThread().getName());
//		for(int i = 1; i<=5; i++){
//			System.out.println("Main Thread "+i+" "+Thread.currentThread().getName());
//		}
		
	}

}
