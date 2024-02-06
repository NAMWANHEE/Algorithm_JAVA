import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class bj_2294 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int dp [] = new int[k+1];
		for(int i=1;i<k+1;i++) {
			dp[i] = 1000001;
		}
		Set<Integer> set = new TreeSet<>();
		for(int i=0;i<n;i++) {
			int coin = sc.nextInt();
			set.add(coin);
		}
		for(int i=1;i<k+1;i++) {
			
			for(int price:set) {
				if(price>i) break;
				dp[i] = Math.min(dp[i], dp[i-price]+1);
			}
		}
		System.out.println(Arrays.toString(dp));
		if(dp[k] >= 10001) System.out.println(-1);
		else System.out.println(dp[k]);

	}

}
