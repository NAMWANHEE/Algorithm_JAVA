import java.util.HashSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.Set;

public class bj_2531 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int cnt[] = new int[d+1];
		cnt[c] = 1;
		int ans = 1;
		for(int i=0;i<k;i++) {
			if(cnt[arr[i]]==0) ans++;
			cnt[arr[i]] ++;
		}

		int max = ans;
		for(int i=1;i<n;i++) {
			int remove = i-1;
			int next = (i+k-1) % n;
			if(cnt[arr[remove]] == 1) ans--;
			cnt[arr[remove]]--;
			if(cnt[arr[next]] ==0) ans++;
			cnt[arr[next]]++;
			max = Math.max(max, ans);

		}
		System.out.println(max);
		

	}

}
