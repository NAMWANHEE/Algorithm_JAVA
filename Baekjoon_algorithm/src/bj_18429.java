import java.util.Arrays;
import java.util.Scanner;

public class bj_18429 {

	static int n,k,arr[], a[], ans=0;
	static boolean visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		arr= new int[n];
		visit = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		a = new int[n];

		permutation(0);
		System.out.println(ans);
		
	}

	private static void permutation( int depth) {
		if(depth == n) {
			int sum = 500;
			boolean check = true;
			for(int i=0;i<n;i++) {
				sum += a[i] - k;
				if(sum<500) {
					check = false;
					break;
				}
			}
			if(check) ans++;
		}

		for(int i=0;i<n;i++) {
			if(visit[i] != true) {
				a[depth] = arr[i];
				visit[i] = true;
				permutation(depth+1);
				visit[i] =false;
				a[depth] = 0;
			}

		}
		
		
		
	}

}
