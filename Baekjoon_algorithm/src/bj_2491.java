import java.util.Arrays;
import java.util.Scanner;

public class bj_2491 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int [] up = new int[n]; // 증가하는 수열
		int [] down = new int[n]; // 감소하는 수열
		int ans = 1;
		up[0] = down[0] = 1;
		for(int i=0;i<n-1;i++) {
			if(arr[i] < arr[i+1]) {
				up[i+1] = up[i] + 1;
				ans = Math.max(ans, up[i+1]);
				down[i+1] = 1;
			}
			else if(arr[i] > arr[i+1]) {
				up[i+1] = 1;
				down[i+1] = down[i] + 1;
				ans = Math.max(ans, down[i+1]);
			}
			else {
				up[i+1] = up[i] + 1;
				down[i+1] = down[i] + 1;
				ans = Math.max(ans, Math.max(up[i+1], down[i+1]));
			}
		}
		System.out.println(ans);
	}

}
