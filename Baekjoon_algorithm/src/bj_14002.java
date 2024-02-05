import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj_14002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		int [] dp = new int[n];
		List<Integer> [] dp2 = new List[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
			dp2[i] = new ArrayList<>();
			dp2[i].add(arr[i]);
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j]) {
					if(dp[i] < dp[j]+1) {
						dp[i] = dp[j]+1;
						dp2[i] = new ArrayList<>(dp2[j]);
						dp2[i].add(arr[i]);
					}
					//[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int ans = 0;
		int idx = 0;
		for(int i=0;i<n;i++) {
			if(ans < dp[i]) {
				ans = dp[i];
				idx = i;
			}
		}
		System.out.println(ans);
		for(int i: dp2[idx]) {
			System.out.print(i+" ");
		}

	}

}
