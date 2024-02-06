import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj_1699 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp [] = new int [n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<n+1;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=Math.sqrt(n);i++) {
			list.add((int) Math.pow(i, 2));
		}
		
		for(int i=2;i<n+1;i++) {
			
			for(int a: list) {
				if(i<a) break;
				dp[i] = Math.min(dp[i], dp[i-a]+1);
			}
		}
		System.out.println(dp[n]);

	}

}
