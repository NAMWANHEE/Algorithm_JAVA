import java.util.Arrays;
import java.util.Scanner;

public class bj_2011 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();
		
		int dp[][] = new int[len][27];
		int s = str.charAt(0)-48;
		dp[0][s] = 1;
		
		for(int i=1;i<len;i++) {
			int num = str.charAt(i)-48;
			for(int j=1;j<27;j++) {
				if(dp[i-1][j]!=0) {
					if(j*10 + num < 27) {
						dp[i][j*10+num] += dp[i-1][j] % 1000000;
						if(num !=0)
							dp[i][num] += dp[i-1][j]% 1000000;
					}
					else if(num !=0) dp[i][num] += dp[i-1][j]% 1000000;

				}
			}
		}

		int ans = 0;
		for(int i=1;i<27;i++) {
			ans= (ans+dp[len-1][i]) % 1000000 ;
		}

		System.out.println(ans);

	}

}
