/* Author: Liam Erickson
 * File: SinglyLinkedList.java
 * Date: May 28, 2020
 */

public class SinglyLinkedList<T> {

	private Node first = null; // top of stack
	private Node last = null;
	private int n = 0;

	class Node {
		T value;
		Node next;
		Node(T value) {
			this.value = value;
			this.next = next;
		}
	}

	public void insertFirst(T value) {
		Node temp = new Node(value);
		temp.next = first;
		first = temp;
		if (last == null) {
			last = temp;
		}
		n++;
	}

	public void insertLast(T value) {
		Node temp = new Node(value);
		if (last == null) {
			last = temp;
			first = temp;
		} else {
			last.next = temp;
			last = temp;
		}
		n++;
	}

	public void insert(int position, T value) {
		if ((position < 0) || (position > n)) {
			throw new RuntimeException("Error: No such position!");
		}
		if (position == 0) {
			insertFirst(value);
		} else if (position == n) {
			insertLast(value);
		} else {
			Node temp = new Node(value);
			Node otherTemp = first;
			for (int i = 0; i < position - 1; i++)
				otherTemp = otherTemp.next;
			temp.next = otherTemp.next;
			otherTemp.next = temp;
			n++;
		}
	}

	T removeFirst() {
		if (first == null)
			throw new RuntimeException("Error: The list is empty!");
		Node temp = first;
		first = temp.next;
		if (first == null) last = null;
		n--;
		return temp.value;
	}

	T removeLast() {
		if (last == null)
			throw new RuntimeException("Error: List is Empty!");
		if (n == 1) //with only 1 object in stack, removeLast doesnt work w/out this
			return removeFirst();
		Node firstN = first;
		Node temp = firstN.next;
		for (int i = 0; i < this.n - 2; i++) {
			firstN = firstN.next;
			temp = firstN.next;
		}
		last = firstN;
		if (last == null) first = null;
		firstN.next = null;
		n--;
		return temp.value;
	}

	T remove(int position) {
		if ((position < 0) || (position >= n)) {
			throw new RuntimeException("Error: No such position!");
		}
		if (position == 0) {
			return removeFirst();
		} else if (position == n - 1) {
			return removeLast();
		} else {
			Node temp = first;
			Node otherTemp = temp.next;
			for (int i = 0; i < position - 1; i++) {
				temp = temp.next;
				otherTemp = temp.next;
			}
			temp.next = otherTemp.next;
			n--;
			return otherTemp.value;
		}
	}
	
	public T getFirst() {
		if (first == null) {
			throw new RuntimeException("Error: List is Empty!");			
		}
		return first.value;
	}
	
	public T getLast() {
		if (last == null) {
			throw new RuntimeException("Error: List is Empty!");			
		}
		return last.value;
	}
	
	public T get (int position) {
		if ((position < 0) || (position >= n)) {
			throw new RuntimeException("Error: Invalid Position!");
		}
		if (position == 0) {
			return getFirst();
		} else if (position == n - 1) {
			return getLast();
		} else {
			Node temp = first;
			for (int i = 0; i < position; i++) {
				temp = temp.next;
			}
			return temp.value;
		}
	}
	
	public int count() {
		return n;
	}

	public boolean isEmpty() {
		return (first == null);
	}

}
