import java.util.Scanner;

public class bj_11058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long [] dp = new long[n+1];
		for(int i=1;i<=n;i++) {
			dp[i] = dp[i-1]+1;
			if(i<7) continue;
			int s = 2;
			for(int j=i-3;j>=1;j--) {
				dp[i] = Math.max(dp[i], dp[j]*s);
				s++;
			}
		}
		System.out.println(dp[n]);

	}

}
