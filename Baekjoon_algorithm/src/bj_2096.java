import java.util.Arrays;
import java.util.Scanner;
public class bj_2096 {
	
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[][] = new int[n][3];
		int min[][] = new int[n][3];
		int max[][] = new int[n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				int num = sc.nextInt();
				dp[i][j] = num;
				dp[i][j] = num;
				dp[i][j] = num;
				if(i==0) {
					max[i][j] = num;
					min[i][j] = num;
				}
				
			}
		}

		
		for(int i=1;i<n;i++) {
			for(int j=0;j<3;j++) {
				if(j==0) {
					min[i][j] = Math.min(min[i-1][j], min[i-1][j+1])+dp[i][j];
					max[i][j] = Math.max(max[i-1][j],max[i-1][j+1]) + dp[i][j];
					
				}
				else if(j==1) {
					min[i][j] = Math.min(min[i-1][j], Math.min(min[i-1][j-1], min[i-1][j+1]))+dp[i][j];
					max[i][j] = Math.max(max[i-1][j], Math.max(max[i-1][j-1], max[i-1][j+1]))+dp[i][j];
					

				}
				else {
					min[i][j] = Math.min(min[i-1][j], min[i-1][j-1])+dp[i][j];
					max[i][j] = Math.max(max[i-1][j],max[i-1][j-1]) + dp[i][j];
				}
			}

		}
		int maxn = 0;
		int minn = Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			if(maxn<max[n-1][i]) maxn = max[n-1][i];
			if(minn>min[n-1][i]) minn = min[n-1][i];
		}

		System.out.println(maxn+" "+minn);

	}

	

	

}
