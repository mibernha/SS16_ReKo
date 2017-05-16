package Aufgabe2;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
	
	private static final int threadMax = 10;
	private static int runCount = 0;
	Random rnd = new Random();


//	Aufgabe c
//	public synchronized void sth(){
//	public static synchronized void sth(){
//		runCount++;
//		System.out.println(runCount + ": " + Thread.currentThread().getName());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	Aufgabe 2 Teil a + b:
//	public void run(){
//			while(runCount < 100){
//				sth();
//			}	
//	}
	//Aufgabe 2 Teil d:
	
	public void run(){
		while(runCount++ < 100){
			MyAccount myac = new MyAccount();
			int change = rnd.nextInt(2);
			if(change == 0){
				change = -1;
			}
			synchronized (MyThread.class) {
				int pre = myac.getWert();
				myac.setWert(pre+change);
				int aft = myac.getWert();
				System.out.println(runCount + ": " + Thread.currentThread().getName() + " " + pre + " + " + change + " = " + aft);
			}
		}	
	}

	public static void main(String[] args) {
		//Aufgabe 2 Teil a + b + c + d
		for(int i = 0; i < threadMax; i++){
			new MyThread().start();
		}
	}

}
