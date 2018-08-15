package a;

public class DecimalToBinary {

	public static void main(String[] args) {
		int num = 57;
		int pow = 1;
		int dis = 2;
		int n = 0;
		while (num != 0) {
			int temp = num / dis;
			n += pow * (num % dis);
			pow = pow * 10;
			num = temp;
		}
		System.out.println(n);
	}

}
