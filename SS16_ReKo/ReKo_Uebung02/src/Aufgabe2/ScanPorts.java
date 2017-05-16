package Aufgabe2;

public class ScanPorts {
	private static final String hostname = "localhost";
	
	public static void main(String[] args) {
//		SimplePortScanner sps = new SimplePortScanner("127.0.0.1", 0);
		//starten mit übergabe von Timeout 0 = infinite 
//		sps.checkPorts(10);
//		PortScannerThreadPool pstp = new PortScannerThreadPool("127.0.0.1", 70, 10);
//		PortScannerThreadPool pstp = new PortScannerThreadPool("141.37.11.233", 500, 200);
		PortScannerThreadPool pstp = new PortScannerThreadPool("192.168.0.1", 100, 500);
		pstp.checkAllPorts();
	}

}
