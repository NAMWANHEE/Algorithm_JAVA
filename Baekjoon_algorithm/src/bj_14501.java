import java.util.Arrays;
import java.util.Scanner;

public class bj_14501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp [] = new int[n+1];
		for(int i=0;i<n;i++) {
			int t = sc.nextInt();
			int p = sc.nextInt();
			if(t+i <= n) {
				dp[t+i] = Math.max(dp[t+i], dp[i]+p);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[n]);
	}

}
