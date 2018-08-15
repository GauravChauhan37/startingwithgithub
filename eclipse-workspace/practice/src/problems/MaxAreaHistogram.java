package problems;

import java.util.LinkedList;

public class MaxAreaHistogram {

	public static void main(String[] args) {
		int[] area = { 2, 1, 2, 3, 1 };
		maxArea(area);
	}

	private static void maxArea(int[] area) {
		LinkedList<Integer> stack = new LinkedList<>();
		stack.addFirst(0);
		int i = 1;
		int ar = 0;
		int maxArea = Integer.MIN_VALUE;
		while (stack.size() != 0) {
			if (area[i] < area[stack.peek()]) {
				stack.addFirst(i);
				i++;
			} else {
				int top = stack.removeFirst();
				if (!stack.isEmpty())
					ar = area[top] * (i - stack.peek() - 1);
				else
					ar = area[top] * i;
			}
			if (ar > maxArea) {
				maxArea = ar;
			}
		}
		System.out.println(maxArea);
	}
}
