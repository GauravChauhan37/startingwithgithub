package problems;

public class PowerInLogn {

	public static void main(String[] args) {
		int num = 2;
		int power = 5;
		int ans = power(num, power);
		System.out.println(ans);
	}

	private static int power(int num, int power) {
		if (power < 0) {
			return -1;
		}
		if (power == 0) {
			return 1;
		}
		if (power == 1) {
			return num;
		}
		int temp = power(num, power / 2);
		if (power % 2 == 0) {
			return temp * temp;
		} else {
			return num * temp * temp;
		}
	}

}
