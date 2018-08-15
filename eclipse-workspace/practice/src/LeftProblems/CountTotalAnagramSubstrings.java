package LeftProblems;

import java.util.HashMap;

public class CountTotalAnagramSubstrings {

	public static void main(String[] args) {
		String s = "xyyx";
		countOfSubs(s);
	}

	private static void countOfSubs(String s) {
		HashMap<String, Integer> hs = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String sub = s.substring(i, j + 1);

				int[] freq = new int[26];
				for (int k = 0; k < sub.length(); k++) {
					freq[sub.charAt(k) - 'a']++;
				}

				String newString = "";
				for (int p = 0; p < freq.length;) {
					if (freq[p] != 0) {
						newString += (char) (p + 'a');
						freq[p]--;
					} else
						p++;
				}
				if (hs.containsKey(newString)) {
					hs.put(newString, hs.get(newString) + 1);
				} else {
					hs.put(newString, 1);
				}
			}
		}
		int count = 0;
		for (String it : hs.keySet()) {
			count += countSubString(hs.get(it));
		}
		System.out.println(count);
	}

	private static int countSubString(int num) {
		return (num * (num - 1)) / 2;
	}
}
