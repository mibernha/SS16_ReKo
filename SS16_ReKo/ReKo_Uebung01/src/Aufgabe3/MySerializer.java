package Aufgabe3;
import java.io.*;

public class MySerializer {
	private MySerializableClass mySerializableClass;
	
	MySerializer(MySerializableClass serializableClass) {
		mySerializableClass=serializableClass;
	}
	
	private String readFilename() throws IOException {
		String filename;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in )); 
		
		System.out.print("filename> ");
		filename=reader.readLine();
		
		return filename;
	}
	
	public void write(String text) throws IOException {
		mySerializableClass.set(text);
		String filename=readFilename();
		
		// Implementierung erforderlich
		// Serialisiere mySerializableClass in Datei
		ObjectOutputStream oSt = null;
		try {
			oSt = new ObjectOutputStream (new FileOutputStream(filename));
			oSt.writeObject(mySerializableClass);
		} catch(IOException ioex) {
			System.out.println(ioex);
		} finally {
			try{
				if(oSt != null){
					oSt.flush();
					oSt.close();
				}
			} catch(IOException ioex2){
				
			}
		}
	
	}
	
	public String read() throws IOException, ClassNotFoundException {
		String filename = readFilename();
		
		// Implementierung erforderlich
		// Serialisiere mySerializableClass von Datei
		
		ObjectInputStream iSt = null;
//		MySerializableClass obj = null;
		try{
			iSt = new ObjectInputStream(new FileInputStream(filename));
//			obj = (MySerializableClass) iSt.readObject();
			mySerializableClass = (MySerializableClass) iSt.readObject();
		} catch(FileNotFoundException fnfex){
			System.out.println("Keine Datei mit diesem Namen gefunden.");
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			try { 
                if(iSt != null) {
                	iSt.close();
                }
            } catch(IOException e) {} 
		}
		return mySerializableClass.toString();
	}
} 
	