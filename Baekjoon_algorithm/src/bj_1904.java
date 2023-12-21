import java.util.Scanner;

public class bj_1904 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n+1];
		if(n == 1) {
			System.out.println(1);
		}
		else if(n == 2) {
			System.out.println(2);
		}
		else {
			dp[1] = 1;
			dp[2] = 2;

			for(int i=3;i<n+1;i++) {
				dp[i] = (dp[i-1]%15746+dp[i-2]%15746) %15746;
			}
			System.out.println(dp[n]);
		}

	}

}
