package Aufgabe2;

import java.net.InetSocketAddress;
import java.net.Socket;

public class checkPorts extends Thread {
	public int port;
	public String ip;
	public int timeout;
	
	public checkPorts(String ip, int port, int timeout){
		this.port = port;
		this.ip = ip;
		this.timeout = timeout;
	}	
		
	public void run() {
		try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(ip, port), timeout);
			System.out.println("Verbunden mit " + ip + " auf Port " + port);
			socket.close();
		} catch (Exception e){
//			System.out.println("Nicht verbunden mit: " + port);
		}
	}
}
