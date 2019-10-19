package myHash;
import java.util.*;

public class MyHashMap<K, V> {
	// inner static class
	public static class Entry<K, V> {
		// field is accessible in the same package
		final K key;
		V value;
		Entry<K, V> next;
		Entry(K key, V value) { // can only new Entry in the same package
			this.key = key;
			this.value = value;
		}
		// allow user to get the key
		public K getKey() {
			return key;
		}
		// allow user to get the value
		public V getValue() {
			return value;
		}
		// allow user to set the value of corresponding key
		// return previous value
		public V setValue(V newVal) {
			V oldVal = value;
			value = newVal;
			return oldVal;
		}
	}
	
	public static final int DEFAULT_CAPACITY = 16;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private int size;
	private float loadFactor;
	private Entry<K, V>[] buckets;
	
	public MyHashMap(int capacity, float loadFactor) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		buckets = (Entry<K, V>[])(new Entry[capacity]);
		this.loadFactor = loadFactor;
		size = 0;
	}
	
	public MyHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR); // overwrite
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	// clear all the hash map
	public void clear() {
		Arrays.fill(buckets, null);
		size = 0;
	}
	// put/update <key, value>
	// return previous value, if key was not in the map, return null
	public V put(K key, V value) {
		int idx = getIdx(key);
		Entry<K, V> head = buckets[idx];	
		Entry<K, V> cur = head;
		while (cur != null) {
			if (equalsKey(cur.key, key)) {
				V prev = cur.value;
				cur.setValue(value);
				return prev; 
			} else {
				cur = cur.next;
			}
		}
		// key does not exist, add this <key, value> to the hash map
		Entry<K, V> newHead = new Entry<K, V>(key, value);
		newHead.next = head;
		buckets[idx] = newHead;
		size++;
		if (needRehashing()) {
			rehash();
		}
		return null;
	}

	
	// return value of current key
	// if key does not exist, return null
	public V get(K key) {
		int idx = getIdx(key);
		Entry<K, V> head = buckets[idx];
		while (head != null) {
			if (equalsKey(head.key, key)) {
				return head.value;
			} else {
				head = head.next;
			}
		}
		return null;
	}
	
	public boolean containsKey(K key) {
		// special case
		if (isEmpty()) {
			return false;
		}
		int idx = getIdx(key);
		Entry<K, V> head = buckets[idx];
		while (head != null) {
			if (equalsKey(head.key, key)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}
	
	public boolean containsValue(V value) {
		if (isEmpty()) {
			return false;
		}
		for (Entry<K, V> bucket : buckets) {
			while (bucket != null) {
				if (equalsValue(bucket.value, value)) {
					return true;
				}
				bucket = bucket.next;
			}
		}
		return false;
	}	
	// return previous value if remove successfully
	// return null if it doesn't have such key
	public V remove(K key) {
		int idx = getIdx(key);
		Entry<K, V> head = buckets[idx];
		Entry<K, V> prev = null;
		while (head != null) {
			if (equalsKey(head.key, key)) {
				V result = head.value;
				prev.next = head.next;
				size--;
				return result;
			}
			prev = head;
			head = head.next;
	   }
		return null;
	}
	
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> set = new HashSet<>();
		for (Entry<K, V> bucket : buckets) {
			while (bucket != null) {
				set.add(bucket);
				bucket = bucket.next;
			}
		}
		return set;
	}
	
	private int getIdx(K key) {
		if (key == null) {
			return 0;
		}
		int hash = key.hashCode();
		hash &= 0x7FFFFFFF; // make it non-negative
		return hash % buckets.length;
	}
	
	private boolean equalsValue(V val1, V val2) {
		return val1 == val2 || val1 != null && val1.equals(val2);
	}
	
	private boolean equalsKey(K k1, K k2) {
		return k1 == k2 || k1 != null && k1.equals(k2);
	}
	
	private boolean needRehashing() {
		return (size + 0.0f) / buckets.length >= loadFactor; 
	}
	
	private void rehash() {
		int capacity = buckets.length;
		Set<Entry<K, V>> set = entrySet();
		buckets = (Entry<K, V>[])(new Entry[capacity * 2]); // expand capacity twice
		for (Entry<K, V> bucket : set) {
			put(bucket.key, bucket.value);
		}
	}
}









