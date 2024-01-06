import java.util.Arrays;
import java.util.Scanner;

public class bj_11055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		int [] dp = new int[n];
		int ans = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
			ans = Math.max(ans, dp[i]);
			for(int j=i-1;j>=0;j--) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
					ans = Math.max(ans, dp[i]);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(ans);
		

	}

}
