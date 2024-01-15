import java.util.Arrays;
import java.util.Scanner;

public class bj_2482 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int dp[][] = new int [n+1][k+1];
		for(int i=0;i<n+1;i++) {
			dp[i][1] = i;
		}
		if(n < 2*k) {
			System.out.println(0);
		}
		else if(k == 1) {
			System.out.println(dp[n][1]);
		}
		else {
			for(int i=4;i<n+1;i++) {
				for(int j=2;j<k+1;j++) {
					dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % 1000000003;
				}
			}
			System.out.println(dp[n][k]);
		}
	}

}
