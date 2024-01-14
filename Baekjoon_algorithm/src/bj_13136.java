import java.util.Scanner;

public class bj_13136 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long r = sc.nextInt();
		long c = sc.nextInt();
		long n = sc.nextInt();
		long ans = 0;
		if(r%n == 0) {
			ans = r/n;
		}
		else {
			ans = r/n +1;
		}
		if(c%n == 0) {
			ans = ans* c/n;
		}
		else {
			ans = ans* ((c/n)+1);
		}
		System.out.println(ans);

	}

}
