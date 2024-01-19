import java.util.Arrays;
import java.util.Scanner;

public class softeer_GBC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int ans = 0;
		int standard[] = new int[100];
		int idx = 0;
		for(int i=0;i<n;i++) {
			int len = sc.nextInt();
			int speed = sc.nextInt();
			for(int j=idx;j<idx+len;j++) {
				standard[j] = speed;
			}
			idx += len;
		}
		idx = 0;
		for(int i=0;i<m;i++) {
			int len = sc.nextInt();
			int speed = sc.nextInt();
			for(int j=idx;j<idx+len;j++) {
				if(speed > standard[j]) ans = Math.max(ans, speed-standard[j]);
			}
			idx += len;
		}
		System.out.println(ans);

	}

}
