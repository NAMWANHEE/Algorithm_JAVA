import java.util.Arrays;
import java.util.Scanner;

public class bj_17404 {

	static int n;
	static int map[][];
	static int ans[][];
	static int ans1 = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][3];
		ans = new int[n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<3;i++) {
			method(i);
			if(i==0) ans1 = Math.min(Math.min(ans[n-1][1],ans[n-1][2]),ans1);
			if(i==1) ans1 = Math.min(Math.min(ans[n-1][0],ans[n-1][2]),ans1);
			if(i==2) ans1 = Math.min(Math.min(ans[n-1][1],ans[n-1][0]),ans1);

		}
		System.out.println(ans1);
		

	}
	private static void method(int start) {

		for(int i=0;i<3;i++) {
			if(i==start) {
				ans[0][i] = map[0][i];
			}
			else {
				ans[0][i] = 10000;
			}
		}
		for(int i=1;i<n;i++) {
			ans[i][0] = Math.min(ans[i-1][1], ans[i-1][2])+map[i][0];
			ans[i][1] = Math.min(ans[i-1][0], ans[i-1][2])+map[i][1];
			ans[i][2] = Math.min(ans[i-1][1], ans[i-1][0])+map[i][2];

			
		}
		
	}

}
