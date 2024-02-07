import java.util.Scanner;

public class bj_2225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int dp[][] = new int[k+1][n+1]; // ���� ����ϴ� ������ ���� ���� ��������ϴ� ���� 
		
		for(int i=0;i<n+1;i++) {
			dp[1][i] = 1; // 1���� ���ڷ� ���� i�� ���� �� �ִ� ��� �� �ڱ� �ڽ� 1���� 
		}
		for(int i=0;i<k+1;i++) {
			dp[i][0] = 1; // ���� ��� �̿��ϵ� 0�� ���� �� �ִ� ����� ���� 1����
		}
		for(int i=2;i<k+1;i++) {
			
			for(int j=1;j<n+1;j++) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
			}
		}
		System.out.println(dp[k][n]);

	}

}