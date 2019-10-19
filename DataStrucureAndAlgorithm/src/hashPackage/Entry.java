package hashPackage;

public class Entry {
	int key;
	Object value;
	Entry next;
	
	public Entry(int key, Object value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
		next = null;
	}
	
	public Entry() {
		next = null;
	}
	
	public int getKey() {
		return key;
	}
	
	public Object value() {
		return value;
	}

}
