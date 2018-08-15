package a;

public class GCD {

	public static void main(String[] args) {

		int div = 1000;
		int dis = 500;
		gcd(div, dis);
	}

	private static void gcd(int div, int dis) {
		while (true) {
			int temp = div % dis;
			if (temp == 0) {
				System.out.println(dis);
				break;
			}
			div = dis;
			dis = temp;
		}
	}

}
