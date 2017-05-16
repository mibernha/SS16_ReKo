package Aufgabe3;
import java.io.Serializable;

public class MySerializableClass implements Serializable{
	private static final long serialVersionUID=1;
	private int id;
	private String string;
	transient MyNonSerializableClass nsz;
	
	MySerializableClass() {
		id=1234;
		nsz = new MyNonSerializableClass();
	}
	
	public void set(String string) {
		this.string=string;
	}
	
	public String toString() {
		return "id: " + id + "; string: "+string + " " + nsz;
	}
} 
	