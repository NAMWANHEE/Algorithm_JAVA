import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bj_5557 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp [][] = new long[n][21];
		int num [] = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		
		dp[0][num[0]] = 1;
		
		for(int i=1;i<n-1;i++) {
			int c = num[i];
			for(int j=0;j<21;j++) {
				if(dp[i-1][j] != 0) {
					int num1 = j+c;
					int num2 = j-c;
					if(num1<=20) dp[i][num1] += dp[i-1][j];
					if(num2 >= 0) dp[i][num2] += dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n-2][num[n-1]]);


	}

}
