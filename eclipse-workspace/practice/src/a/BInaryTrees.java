package a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//50 true 25 true 12 false false true 37 false false true 75 true 62 false
//false true 57 false false
public class BInaryTrees {
	static class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;
	int size;

	public BInaryTrees() {
		this.root = construct(this.root, new Scanner(System.in));
	}

	private Node construct(Node node, Scanner sc) {
		node = new Node();
		node.data = sc.nextInt();
		if (root == null)
			root = node;
		System.out.println("Do this node have a left child");
		boolean ilc = sc.nextBoolean();
		if (ilc == true) {
			node.left = construct(node.left, sc);
		}
		System.out.println("Do this node have a right child");
		boolean irc = sc.nextBoolean();
		if (irc == true) {
			node.right = construct(node.right, sc);
		}
		return node;
	}

	public void display(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null)
			System.out.print(node.left.data + " ");
		else
			System.out.print(".  ");
		System.out.print(node.data + " ");
		if (node.right != null)
			System.out.print(node.right.data + " ");
		else
			System.out.print(" .");
		System.out.println();
		display(node.left);
		display(node.right);
	}

	public static boolean find(Node node, int data) {
		if (node == null)
			return false;
		if (node.data == data)
			return true;
		boolean isFound = false;
		isFound = isFound || find(node.left, data);
		isFound = isFound || find(node.right, data);
		return isFound;
	}

	static class MultiSolver {
		boolean isFound;
		ArrayList<Node> al = new ArrayList<>(); // root to node path
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int justLarger = Integer.MAX_VALUE;
	}

	public void Multi(int data) {
		MultiSolver ml = new MultiSolver();
		solve(ml, data, this.root);
		System.out.println(ml.isFound);
//		System.out.println(ml.al);
		System.out.println(ml.max + " " + ml.min);
		System.out.println(ml.justLarger);
	}

	private void solve(MultiSolver ml, int data, Node node) {
		if (node == null) {
			return;
		}
		if (node.data == data) {
			ml.isFound = true;
		}
		if (node.data > data && node.data < ml.justLarger) {
			ml.justLarger = node.data;
		}
		if (node.data < ml.min)
			ml.min = node.data;
		if (node.data > ml.max)
			ml.max = node.data;
		if (ml.isFound == false) {
			solve(ml, data, node.left);
			solve(ml, data, node.right);
		}
		if (ml.isFound == true) {
			ml.al.add(node);
		}
	}

	public static void main(String args[]) {
		BInaryTrees b = new BInaryTrees();
		b.display(b.root);
		System.out.println("******");
		b.Multi(57);
//		System.out.println(b.Height(b.root));
//		System.out.println("*****");
//		b.printSingleChild(b.root);
//		System.out.println("******");
////		b.removeleaves(b.root);
////		b.display(b.root);
		System.out.println("*********");
//		b.LevelOrder();
//		DiPair ans = b.Diameter(root);
//		System.out.println(ans.diameter);
//		b.PreOrderIterative(root);
//		b.InorderIterative(root);
//		b.PostOrderInterative(root);
		b.PrintkFarAwayFromData(root, 2);
	}

	public int Height(Node node) {
		if (node == null)
			return 0;
		int height = 0;
		height = Math.max(Height(node.left), height);
		height = Math.max(Height(node.right), height);

		return height + 1;
	}

	public Node printSingleChild(Node node) {
		if (node.left != null && node.right != null) {
			node.left = printSingleChild(node.left);
			node.right = printSingleChild(node.right);
		} else if (node.left == null && node.right != null) {
			System.out.println(node.right.data);
			node.right = printSingleChild(node.right);
		} else if (node.left != null && node.right == null) {
			System.out.println(node.left.data);
			node.left = printSingleChild(node.left);
		}
		return node;
	}

	public Node removeleaves(Node node) {
		if (node.left == null && node.right == null) {
			return null;
		}
		node.left = removeleaves(node.left);
		node.right = removeleaves(node.right);
		return node;
	}

	public static void LevelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (queue.size() != 0) {
			Node rn = queue.removeFirst();
			System.out.println(rn.data);
			if (rn.left != null)
				queue.addLast(rn.left);

			if (rn.right != null)
				queue.addLast(rn.right);
		}
	}

	static class DiPair {
		int height;
		int diameter;
	}

	public static DiPair Diameter(Node node) {
		if (node == null) {
			DiPair d = new DiPair();
			d.height = -1;
			d.diameter = 0;
			return d;
		}
		DiPair mp = new DiPair();
		DiPair a = Diameter(node.left);
		DiPair b = Diameter(node.right);
		mp.height = 1 + Math.max(a.height, b.height);
		mp.diameter = Math.max(a.diameter, Math.max(b.diameter, 2 + a.height + b.height));
		return mp;
	}

	public void PreOrderIterative(Node node) {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(node);
		while (stack.size() != 0) {
			Node rm = stack.removeFirst();
			System.out.println(rm.data);
			if (rm.left != null)
				stack.addFirst(rm.right);
			if (rm.right != null)
				stack.addFirst(rm.left);
		}
	}

	public void InorderIterative(Node node) {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(node);
		while (stack.size() != 0) {
			if (node.left != null) {
				stack.addFirst(node.left);
				node = node.left;
			} else {
				node = stack.removeFirst();
				System.out.println(node.data);
				if (node.right != null) {
					stack.addFirst(node.right);
					node = node.right;
				}
			}
		}
	}

	public void PostOrderInterative(Node node) {
		LinkedList<Node> stack = new LinkedList<>();
		stack.add(node);
		while (stack.size() != 0) {
		}
	}

	public void PrintkFarAwayFromData(Node node, int k) {
		MultiSolver ml = new MultiSolver();
		solve(ml, 12, root);
		for (int i = 0; i < k; i++) {
			if (i == 0) {
				printKdown(ml.al.get(i), k);
			} else if (i == k - 1) {
				System.out.println(ml.al.get(i).data);
			} else {
				if (ml.al.get(i - 1) == ml.al.get(i).left) {
					printKdown(ml.al.get(i).right, k - i - 1);
				} else if (ml.al.get(i - 1) == ml.al.get(i).right) {
					printKdown(ml.al.get(i).left, k - i - 1);
				}
			}
		}
	}

	private void printKdown(Node node, int k) {
		if (k < 0 || node == null) {
			return;
		}
		if (k == 0) {
			System.out.println(node.data);
			return;
		}
		printKdown(node.left, k - 1);
		printKdown(node.right, k - 1);
	}
}
