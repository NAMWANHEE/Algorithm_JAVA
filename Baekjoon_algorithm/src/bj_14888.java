import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj_14888 {
	static int arr[], num[], n, maxn=Integer.MIN_VALUE, minn=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new int[n];
		arr = new int[4];
		for(int i=0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			arr[i] = sc.nextInt();
		}
		method(num[0],1);
		System.out.println(maxn);
		System.out.println(minn);


	}
	
	public static void method(int sum,int depth) {
		if(depth == n) {
			maxn = Math.max(sum, maxn);
			minn = Math.min(sum, minn);
			return;
		}
		for(int i=0;i<4;i++) {
			if(arr[i] != 0) {
				if(i==0) {
					arr[i] -= 1;
					method(sum+num[depth],depth+1);
					arr[i] += 1;
				}
				else if(i==1) {
					arr[i] -= 1;
					method(sum-num[depth],depth+1);
					arr[i] += 1;
				}
				else if(i==2) {
					arr[i] -= 1;
					method(sum*num[depth],depth+1);
					arr[i] += 1;
				}
				else {
					
					arr[i] -= 1;
					method(sum/num[depth],depth+1);
					arr[i] += 1;
				}
			}
		}
	}

}
