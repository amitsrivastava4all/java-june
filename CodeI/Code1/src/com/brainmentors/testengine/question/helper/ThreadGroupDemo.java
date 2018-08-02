package com.brainmentors.testengine.question.helper;

class B implements Runnable{
	@Override
	public void run(){
		for(int i = 1; i<=5; i++) {
		System.out.println("My Thread "+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
		
}
public class ThreadGroupDemo {

 public static void main (String [] args)
 {
   ThreadGroup tg1 = new ThreadGroup ("FirstGroup");
   Thread t1 = new Thread (tg1, new B(),"T1");
   Thread t2 = new Thread (tg1, new B(),"T2");
   Thread t3 = new Thread (tg1, new B() , "T3");

   ThreadGroup tg2 = new ThreadGroup ("SecondGroup");
   Thread t4 = new Thread (tg2, new B(),"t4");
   Thread t5 = new Thread (tg2, new B(), "t5");
   t1.start();
   t2.start();
   t3.start();
   t4.start();
   t5.start();
   System.out.println("ACTIVE TG1  "+tg1.activeCount());
   System.out.println("Active TG2 "+tg2.activeCount());
   tg1.list();
   tg2.list();
   System.out.println("Going to stop Group1");
   tg1.checkAccess();
   tg1.stop();
   System.out.println("Stop All Threads of Group 1");
   
   }
}
