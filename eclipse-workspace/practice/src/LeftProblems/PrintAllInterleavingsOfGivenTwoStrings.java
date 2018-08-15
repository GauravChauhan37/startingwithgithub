package LeftProblems;

public class PrintAllInterleavingsOfGivenTwoStrings {
	static int count = 0;

	public static void main(String[] args) {
		String s1 = "ABEF";
		String s2 = "CD";
		FindAllReqdStrings(s1, s2, 0, 0, "");
		System.out.println(count);
	}

	private static void FindAllReqdStrings(String s1, String s2, int idx1, int idx2, String asf) {
		if (s1.length() == 0 && s2.length() == 0) {
			System.out.println(asf);
			return;
		}
		count++;
		if (s1.length() != 0)
			FindAllReqdStrings(s1.substring(1), s2, idx1, idx2, asf + s1.charAt(0));
		if (s2.length() != 0)
			FindAllReqdStrings(s1, s2.substring(1), idx1, idx2, asf + s2.charAt(0));
	}
}
