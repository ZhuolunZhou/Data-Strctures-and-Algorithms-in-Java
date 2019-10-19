package hashPackage;

public class HashTableArray<T> {
	Entry[] hashArray;
	int size;
	
	public HashTableArray(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		hashArray = new Entry[size];
		
		for (int i = 0; i < size; i++ ) {
			hashArray[i] = new Entry();
		}

	}
	
	int getHash(int key) {
		return key % size;
	}
	
	public void put(int key, Object value) {
		int index = getHash(key);
		Entry arrayValue = hashArray[index];
		Entry newEntry = new Entry(key, value);
		newEntry.next = arrayValue.next;
		arrayValue.next = newEntry;
		
	}
	
	public T get(int key) {
		T value = null;
		int index = getHash(key);
		Entry arrayValue = hashArray[index];
		while (arrayValue != null) {
			if (arrayValue.key == key) {
				value = (T)arrayValue.value;
				break;
			}
			arrayValue = arrayValue.next;
		}
		return value;
	}
}
