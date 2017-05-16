package Aufgabe2;

import java.net.InetSocketAddress;
import java.net.Socket;

public class SimplePortScanner extends Thread {
	public int port;
	public String ip;
	public long start;
	public long dauer;
	
	public SimplePortScanner(String ip, int port){
		this.port = port;
		this.ip = ip;
	}
	
	public void checkPorts(int timeout) {
		System.out.println("Portscan gestartet! Timeout bei " + timeout + "ms");
		start = System.currentTimeMillis();
		while(port < 65535){
			Socket socket = new Socket();
			try {
				socket.connect(new InetSocketAddress(ip, port), timeout);
				System.out.println("Verbunden mit " + ip + " auf Port " + port);
				socket.close();
			} catch (Exception e){
				//hier könnte man ausgeben dass nicht verbunden wurde.
			}
			port++;
		}
		dauer = System.currentTimeMillis() - start;
		System.out.println("Alle Ports überprüft!");
		System.out.println("Dauer: " + dauer/1000 + "s");
	}
}
