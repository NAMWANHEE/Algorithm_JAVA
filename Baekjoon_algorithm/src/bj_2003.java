import java.util.Arrays;
import java.util.Scanner;

public class bj_2003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i=1;i<n+1;i++) {
			arr[i] = sc.nextInt();
			arr[i] += arr[i-1];
		}

		int ans = 0;
		for(int i=0;i<n;i++) {
			
			for(int j=i+1;j<n+1;j++) {
				if(arr[j]-arr[i] == m) ans++;
				if(arr[j]-arr[i] >m) continue;
			}
		}
		System.out.println(ans);
		
	}

}
