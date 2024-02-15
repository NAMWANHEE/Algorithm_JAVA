import java.util.Scanner;

public class bj_22945 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		int left = 0;
		int right = n-1;
		while(left<=right) {
			ans = Math.max(ans, (right-left-1)*Math.min(arr[left], arr[right]));
			if(arr[left] < arr[right]) {
				left += 1;
			}
			else {
				right -= 1;
			}
		}
		System.out.println(ans);

	}

}
