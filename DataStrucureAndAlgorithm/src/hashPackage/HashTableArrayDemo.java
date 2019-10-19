package hashPackage;

public class HashTableArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTableArray<String> ht = new HashTableArray<String>(3);
		ht.put(23, "Zhuolun");
		ht.put(56, "MIKE");
		ht.put(2, "mike");
		ht.put(6456, "ZHUOLUN");
		ht.put(8, "zzl");
		
		String name = ht.get(2);
		System.out.println("The name is "+name+"\n");
		


	}

}
