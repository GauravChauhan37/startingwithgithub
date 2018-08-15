package LeftProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;

public class FoldALinkedList {
	static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	static Node head;
	static Node tail;

	public static void add(Node n) {
		if (head == null) {
			head = tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}

	public static void main(String[] args) throws IOException {
		add(new Node(10, null));
		add(new Node(20, null));
		add(new Node(30, null));
		add(new Node(40, null));
		add(new Node(50, null));
		add(new Node(60,null));
		k = head;
		Fold(head, 0);
		for (Node n = head; n != null; n = n.next) {
			System.out.println(n.data);
		}
	}

	static Node k;
	static int count = 0;

	public static void Fold(Node node, int size) {
		if (node == null) {
			return;
		}
		count++;
		Fold(node.next, ++size);
		if (size > (count / 2) + 1) {
			Node temp = k.next;
			k.next = node;
			node.next = temp;
			k = node.next;
		}
	}
}
