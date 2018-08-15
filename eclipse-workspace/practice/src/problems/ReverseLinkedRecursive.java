package problems;

import java.util.LinkedList;

public class ReverseLinkedRecursive {
	static class Node {
		int data;
		Node next;
	}

	static Node head;
	static Node tail;

	public static void add(int data) {
		Node n = new Node();
		n.data = data;
		if (head == null) {
			head = tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}

	public static void main(String[] args) {
		add(10);
		add(20);
		add(30);
		add(40);
//		display();
		Reverse(head, null);
		Node temp = head;
		head =  tail;
		tail = temp; 
		display();

	}

	private static void Reverse(Node node, Node prev) {
		if (node == null) {
			return;
		}
		Reverse(node.next, node);
		node.next = prev;
		if(prev != null)
		prev.next = null;
	}

	private static void display() {
		for (Node n = head; n != null; n = n.next) {
			System.out.print(n.data + " ");
		}
	}

}
