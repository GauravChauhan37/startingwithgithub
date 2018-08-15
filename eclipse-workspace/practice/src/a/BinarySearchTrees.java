package a;

public class BinarySearchTrees {
	static class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;
	int size;

	public BinarySearchTrees(int[] arr) {
		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node n = new Node();
		n.data = arr[mid];
		n.left = construct(arr, lo, mid - 1);
		n.right = construct(arr, mid + 1, hi);
		return n;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.left == null ? ". " : node.left.data + "  ");
		System.out.print(node.data + " ");
		System.out.print(node.right == null ? ". " : node.right.data + " ");
		System.out.println();
		if (node.left != null)
			display(node.left);
		if (node.right != null)
			display(node.right);

	}

	public static void PrintInrange(Node node, String psf, int ssf, int lo, int hi) {
		if (node.left == null && node.right == null) {
			if (lo <= ssf + node.data && ssf + node.data <= hi) {
				System.out.println(psf + " " + node.data);
			}
			return;
		}
		PrintInrange(node.left, psf + " " + node.data, ssf + node.data, lo, hi);
		PrintInrange(node.right, psf + " " + node.data, ssf + node.data, lo, hi);
	}

	public static Node addNode(Node node, int data) {
		if (node == null) {
			Node n = new Node();
			n.data = data;
			return n;
		}
		if (node.data > data) {
			node.left = addNode(node.left, data);
		} else if (node.data < data) {
			node.right = addNode(node.right, data);
		}
		return node;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		BinarySearchTrees bt = new BinarySearchTrees(arr);
//		bt.display();
////		PrintInrange(root, "", 0, 6, 11);
//		addNode(root, 8);
//		addNode(root, 0);
//		System.out.println("**");
//		removeNode(root, 8);
//		bt.display();
		pair ans = bt.LargestBst(root);
		System.out.println(ans.size);

	}

	public static Node removeNode(Node node, int data) {
		if (node == null) {
			return null;
		}
		if (node.data == data) {
			return null;
		}
		if (node.data > data)
			node.left = removeNode(node.left, data);
		if (node.data < data)
			node.right = removeNode(node.right, data);
		if (node.left == null && node.right == null) {
			return null;
		} else if (node.left != null && node.right != null) {
			Node min = Min(node.right);
			Node n = new Node();
			n.data = min.data;
			n.left = node.left;
			n.right = node.right;
			removeNode(node.right, min.data);
			return n;
		} else {
			if (node.left != null)
				return node.left;
			else
				return node.right;
		}
	}

	private static Node Min(Node node) {
		if (node.left == null && node.right == null) {
			return node;
		}
		return Min(node.left);
	}

	static class pair {
		boolean flag;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int size;
	}

	public static pair LargestBst(Node node) {
		if (node.left == null && node.right == null) {
			pair p = new pair();
			p.flag = true;
			p.size = 0;
			return p;
		}
		pair mp = new pair();
		pair left = LargestBst(node.left);
		pair right = LargestBst(node.right);
		if (node.data > node.left.data && node.data < node.right.data && left.flag == true && right.flag == true) {
			mp.flag = true;
		} else {
			mp.flag = false;
		}
		if (mp.flag == false) {
			if (left.size > right.size) {
				mp.size = 1 + left.size;
			} else {
				mp.size = 1 + right.size;
			}
		} else {
			mp.size = left.size + right.size + 1;
		}
		mp.max = Math.max(node.data, Math.max(left.max, right.max));
		mp.min = Math.min(node.data, Math.min(left.min, right.min));
		return mp;
	}
}
