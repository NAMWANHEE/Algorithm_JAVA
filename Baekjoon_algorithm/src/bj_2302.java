import java.util.Scanner;

public class bj_2302 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i=0;i<m;i++) {
			arr[sc.nextInt()] = 1;
		}
		int dp[] = new int[n+1];
		if(n<2) {
			System.out.println(1);
			System.exit(0);
		}
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<n+1;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		int cnt = 0;
		int ans = 1;
		for(int i=1;i<n+1;i++) {
			if(arr[i] ==1) {
				ans *= dp[cnt];
				cnt = 0;
			}
			else
				cnt++;
		}
		ans *= dp[cnt];
		System.out.println(ans);

	}

}
