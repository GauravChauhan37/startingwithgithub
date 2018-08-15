package LeftProblems;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {
		String s1 = "geek";
		String s2 = "seel";
		SuperSeq(s1, s2);
	}

	private static void SuperSeq(String s1, String s2) {
		String[][] dp = new String[s1.length() + 1][s2.length() + 1];
		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length()) {
					if (j == s2.length()) {
						dp[i][j] = "";
					} else {
						dp[i][j] = s1.substring(j, s1.length());
					}
				} else if (j == s2.length()) {
					if (i == s1.length()) {
						dp[i][j] = "";
					} else {
						dp[i][j] = s2.substring(i, s2.length());
					}
				} else {
					if (s1.charAt(i) == s2.charAt(j)) {
						dp[i][j] = s1.charAt(i) + dp[i + 1][j + 1];
					} else {
						if (dp[i + 1][j].length() < dp[i][j + 1].length()) {
							dp[i][j] = s2.charAt(i) + dp[i + 1][j];
						} else {
							dp[i][j] = s1.charAt(i) + dp[i][j + 1];
						}
					}
				}
			}
		}
		System.out.println(dp[0][0]);
	}
}