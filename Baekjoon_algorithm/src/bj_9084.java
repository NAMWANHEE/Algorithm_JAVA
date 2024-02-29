import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_9084 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=0;tc<t;tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();
			int dp[] = new int[10001];
			for(int i=0;i<n;i++) {
				int s = Integer.parseInt(st.nextToken());
				list.add(s);
			}
			dp[0] = 1;
			int price = Integer.parseInt(br.readLine());

			for(int num :list) {
				for(int i=num;i< price+1;i++) {
					dp[i] += dp[i-num];
					

				}
			}
			System.out.println(dp[price]);
			
		}

	}

}
