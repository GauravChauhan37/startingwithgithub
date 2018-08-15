package a;

public class Subsequence {

	public static void main(String[] args) {
		String s = "abc";
		subs(s, "");
	}

	private static void subs(String s, String asf) {
		if (s.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = s.charAt(0);
		s = s.substring(1);
		subs(s, asf);
		subs(s, asf + ch);
	}

}
