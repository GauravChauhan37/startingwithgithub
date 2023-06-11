package LeftProblems;

public class CheckIfSentenceIsValidOrNot {

	public static void main(String[] args) {
		String s = "Name is Ram.";
		boolean ans = CheckVaid(s);
		System.out.println(ans);
	}

	private static boolean CheckVaid(String s) {
		String password = "pass_prod_12";
		int currState = 0;
		int prevState = 0;
		int idx = 0;
		if (!(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')) {
			return false;
		}
		if (!(s.charAt(s.length() - 1) == '.')) {
			return false;
		}
		if (s.charAt(idx) >= 'A' && s.charAt(idx) <= 'Z') {
			currState = 0;
		}
		if (s.charAt(idx) == '.') {
			currState = 3;
		}
		if (s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') {
			currState = 2;
		}
		if (s.charAt(idx) == ' ') {
			currState = 1;
		}
		if (currState == 0 && prevState == 2) {
			return false;
		}
		if (currState == 3 && prevState == 1) {
			return false;
		}
		return true;
	}
}
