package LRU;
import java.util.*;

public class LRU<K, V> {
	// doubly linked list
	static class Node<K, V> {
		Node<K, V> next;
		Node<K, V> prev;
		K key;
		V value;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		void update(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private final int limit;
	private Node<K, V> head;
	private Node<K, V> tail;
	private Map<K, Node<K, V>> map;

	public LRU(int limit) {
		this.limit = limit;
		this.map = new HashMap<>();
	}

	public void set(K key, V value) {
		Node<K, V> node = null;
		if (map.containsKey(key)) { // update node and move it to the head
			node = map.get(key);
			node.value = value;
			remove(node);
		} else if (map.size() < limit) { // append new node to cache
			node = new Node<>(key, value);
		} else {
			node = tail;
			remove(node);
			node.update(key, value);
		}
		append(node);
	}

	// remove node from the linked list and map
	private Node<K, V> remove(Node<K, V> node) {
		map.remove(node.key);
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		if (node == head) {
			head = head.next;
		}
		if (node == tail) {
			tail = tail.prev;
		}
		node.next = node.prev = null;
		return node;
	}

	// append node to the head
	private Node<K, V> append(Node<K, V> node) {
		map.put(node.key, node);
		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		return node;
	}

	public V get(K key) {
		Node<K, V> node = map.get(key);
		if (node == null) return null;
		remove(node);
		append(node);
		return node.value;
	}
}
