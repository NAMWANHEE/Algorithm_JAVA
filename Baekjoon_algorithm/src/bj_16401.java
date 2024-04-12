import java.util.Arrays;
import java.util.Scanner;

public class bj_16401 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[m];
		for(int i=0;i<m;i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[m-1];
		
		while(left<=right) {
			int mid = (left+right) / 2;
			int cnt = 0;
			for(int i=0;i<m;i++) {
				cnt += arr[i]/mid;
			}
			
			if(cnt>=n) {
				if(ans<mid) ans = mid;
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		System.out.println(ans);

	}

}
