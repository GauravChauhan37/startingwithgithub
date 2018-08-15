package a;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 4, 1, 2, 5, 46, 6, 2, 3, 34, 34 };
		quickSort(arr, 0, arr.length - 1);
		for(Integer i:arr) {
			System.out.print(i+" ");
		}
	}

	private static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int pivot = arr[hi];
		int pivotIdx = partition(arr, lo, hi, pivot);
		quickSort(arr, lo, pivotIdx - 1);
		quickSort(arr, pivotIdx + 1, hi);
	}

	private static int partition(int[] arr, int lo, int hi, int pivot) {
		int lessThanPivot = 0;
		int greaterThanPivot = 0;
		while (greaterThanPivot <= hi) {
			if (arr[greaterThanPivot] > pivot) {
				greaterThanPivot++;
			} else {
				int temp = arr[greaterThanPivot];
				arr[greaterThanPivot] = arr[lessThanPivot];
				arr[lessThanPivot] = temp;
				greaterThanPivot++;
				lessThanPivot++;
			}
		}
		return lessThanPivot-1;
	}

}
