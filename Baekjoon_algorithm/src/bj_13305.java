import java.util.Scanner;

public class bj_13305 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []distance = new int[n-1];
		int []oil = new int[n];
		long min = Long.MAX_VALUE;
		long ans = 0;
		for(int i=0;i<n-1;i++) {
			distance[i] = sc.nextInt();
			
		}
		for(int i=0;i<n;i++) {
			oil[i] = sc.nextInt();
		}
		
		for(int i=0;i<n-1;i++) {
			min = Math.min(min, oil[i]);
			ans+= min*distance[i];
		}
		System.out.println(ans);
		
		

	}

}
