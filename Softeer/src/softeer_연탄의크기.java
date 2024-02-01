import java.util.Scanner;

public class softeer_¿¬ÅºÀÇÅ©±â {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr [] = new int[n];
		int maxnum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			maxnum = Math.max(arr[i], maxnum);
		}
		
		int maxn = maxnum % 2;
		int ans = 0;
		for(int i=2;i<=maxnum;i++) {
			int cnt = 0;
			for(int j=0;j<n;j++) {
				if(arr[j] % i ==0) cnt++;
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);

	}

}
