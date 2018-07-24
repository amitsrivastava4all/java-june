package com.brainmentors.testengine.question;

class DThread implements Runnable{
	public void run() {
		while(true) {
            doSomeThing();
        }
	}
	void doSomeThing() {
		System.out.println("I am Done....");
	}
}



public class DameonThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new DThread());
		t1.setDaemon(false);
		
		t1.start();
		for(int i = 1; i<=5; i++) {
			System.out.println("Main Thread... "+Thread.currentThread());
		}
		
		

	}

}
