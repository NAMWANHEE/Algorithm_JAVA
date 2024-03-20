import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bj_1263 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<int[]> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			int t = sc.nextInt();
			int s = sc.nextInt();
			list.add(new int[] {t,s});
		}
		Collections.sort(list,(o1,o2)->o1[1]-o2[1]);
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int[] arr: list) {
			sum += arr[0];
			min = Math.min(min, arr[1]-sum);
		}
		if(min<0) System.out.println(-1);
		else System.out.println(min);


	}

}
