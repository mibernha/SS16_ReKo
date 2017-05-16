package Aufgabe2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PortScannerThreadPool {
	public String ip;
	public long start;
	public long dauer;
	public int threads;
	public int timeout;
	
	public PortScannerThreadPool(String ip, int threads, int timeout){
		this.ip = ip;
		this.threads = threads;
		this.timeout = timeout;
	}	
	
	public void checkAllPorts() {
		System.out.println("Portscan mit " + threads + " Threads gestartet! Timeout bei " + timeout + "ms");
		start = System.currentTimeMillis();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threads);
		for(int port = 0; port <= 65535; port++){
			checkPorts cp = new checkPorts(ip, port, timeout);
			executor.execute(cp);
		}
		executor.shutdown();
		try {
			executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dauer = System.currentTimeMillis() - start;
		System.out.println("Alle Ports überprüft!");
		System.out.println("Dauer: " + dauer/1000 + "s");
	}
}
