import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class softeer_¼ºÀûÆò±Õ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k =Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long dp[] = new long[n+1];
		dp[0] = 0;
		for(int i=1;i<n+1;i++) {
			dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(dp));
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			double ans = ((double)(dp[b]-dp[a-1]) / (double)(b-a+1));
			System.out.printf("%.2f",ans);
			System.out.println();
		}

	}

	

}
