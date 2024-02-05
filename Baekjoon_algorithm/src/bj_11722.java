import java.util.Arrays;
import java.util.Scanner;

public class bj_11722 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		int [] dp = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}
		System.out.println(Arrays.toString(dp));
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i] < arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		int ans = 0;
		for(int i=0;i<n;i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);


	}

}
