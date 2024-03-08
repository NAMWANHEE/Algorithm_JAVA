import java.util.Arrays;
import java.util.Scanner;

public class bj_18353 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int dp[] = new int[n];
		dp[0] = 1;
		for(int i=1;i<n;i++) {
			dp[i] = 1;
			for(int j=i-1;j>=0;j--) {
				if(arr[i] < arr[j]) {
					dp[i] = Math.max(dp[j]+1,dp[i]);

				}
			}
		}
		int ans =0;
		for(int s:dp) {
			if(ans<s) ans = s;
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(n-ans);

	}

}
