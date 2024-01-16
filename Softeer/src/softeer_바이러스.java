import java.util.Scanner;

public class softeer_바이러스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		long k = sc.nextInt();
		long p = sc.nextInt();
		long n = sc.nextInt();
		while(n!=0) {
			k = ((p%1000000007)*(k%1000000007)) % 1000000007;
			n--;
		}
		System.out.println(k);

	}

}
