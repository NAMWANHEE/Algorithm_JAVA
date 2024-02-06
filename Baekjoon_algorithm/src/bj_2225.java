import java.util.Scanner;

public class bj_2225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int dp[][] = new int[k+1][n+1]; // 행은 사용하는 숫자의 개수 열은 만드려고하는 숫자 
		
		for(int i=0;i<n+1;i++) {
			dp[1][i] = 1; // 1개의 숫자로 숫자 i를 만들 수 있는 경우 는 자기 자신 1개뿐 
		}
		for(int i=0;i<k+1;i++) {
			dp[i][0] = 1; // 숫자 몇개를 이용하든 0을 만들 수 있는 경우의 수는 1개뿐
		}
		for(int i=2;i<k+1;i++) {
			
			for(int j=1;j<n+1;j++) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
			}
		}
		System.out.println(dp[k][n]);

	}

}
