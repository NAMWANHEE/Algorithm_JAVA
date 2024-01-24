import java.util.Arrays;
import java.util.Scanner;

public class bj_2467 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int left = 0;
		int right = n-1;
		
		int la = 0;
		int lr = 0;
		int num = Integer.MAX_VALUE;
		boolean check = true;
		while(left<right) {
			if(arr[left]+arr[right] < 0) {
				if(num > Math.abs(arr[left]+arr[right])) {
					la = left;
					lr = right;
					num = Math.abs(arr[left]+arr[right]);
				}
				left++;
			}
			else if(arr[left]+arr[right]>0) {
				if(num > Math.abs(arr[left]+arr[right])) {
					la = left;
					lr = right;
					num = Math.abs(arr[left]+arr[right]);
				}
				right--;
			}
			else {
				System.out.println(arr[left]+" "+arr[right]);
				check = false;
				break;
			}
		}
		if(check)
			System.out.println(arr[la]+ " "+arr[lr]);

	}

}
