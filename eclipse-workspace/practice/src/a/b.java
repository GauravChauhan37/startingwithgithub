package a;

import java.util.Arrays;

public class b {

	public static void main(String[] args) {
		int[] scores = { 4,8,7 };
		int[] lowerLimits = { 2, 4 };
		int[] upperLimits = { 8, 4 };
		jobOffers(scores, lowerLimits, upperLimits);
	}

	static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
		int[] count = new int[lowerLimits.length];
		int idx = 0;
		Arrays.sort(scores);
		while (idx < lowerLimits.length) {
			int lowerIdx = BinarySearch(scores, lowerLimits[idx], 0, scores.length);
			int highIdx = BinarySearch(scores, upperLimits[idx], 0, scores.length);
			count[idx] = highIdx - lowerIdx + 1;
			idx++;
		}
		return count;
	}

	public static int BinarySearch(int[] arr, int data, int lo, int hi) {
		if (lo > hi) {
			return -1;
		}
		int mid = (lo + hi) / 2;
		if (arr[mid] == data) {
			return mid;
		} else if (mid-1>=0 && arr[mid] > data && arr[mid - 1] < data) {
			return mid;
		} else if (mid+1 <arr.length && arr[mid] < data && arr[mid + 1] > data) {
			return mid + 1;
		}
		int idx = -1;
		if (arr[mid] > data) {
			idx = BinarySearch(arr, data, lo, mid - 1);
		}
		if (arr[mid] < data) {
			idx = BinarySearch(arr, data, mid + 1, hi);
		}
		return idx;
	}
}
