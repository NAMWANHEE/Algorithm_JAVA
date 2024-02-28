import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class bj_12852 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp [] = new int[n+1];
		if(n<4) {
			if(n==1) System.out.println(0);
			else System.out.println(1);
		}
		else {
			dp[1] = 0;
			dp[2] = 1;
			dp[3] = 1;
			for(int i=4;i<n+1;i++) {
				dp[i] = dp[i-1]+1;
				if(i%3 ==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
				if(i%2 ==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			System.out.println(dp[n]);
		}
		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		while(true) {
			if(n==1) break;
			if(n==2||n==3) {
				q.add(1);
				break;
			}
			int num = n-1;
			int min = dp[n-1];
			
			if(n%3==0 && min > dp[n/3]) {
				num = n/3;
				min = dp[n/3];
			}
			if(n%2==0 && min > dp[n/2]) {
				num = n/2;
				min = dp[n/2];
			}
			q.add(num);
			n = num;
			
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			sb.append(q.poll()+" ");
		}
		System.out.println(sb);

		
	}

}
